package com.example.myapplication;

import android.os.StrictMode;

import java.sql.*;

import static java.lang.Class.forName;


public class Repo {
    String connectionString = "jdbc:jtds:sqlserver://ecofeedserver.database.windows.net:1433/EcofeedUser;user=ecofeed@ecofeedserver;password=FeCo2020;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    public void Read() {
        Connection connection = null;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            String sql = "SELECT * from Users";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection(connection);
        }
    }

    public boolean Write(String id, String fn, String ln, String pwd) {
        Connection connection = null;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            String sql = "INSERT into [dbo].[Users] (cmuId, firstName, lastName, password, points)\n" +
                    "VALUES ('" + id + "', '" + fn + "', '" + ln + "', '" + pwd + "', '10')";
            return statement.execute(sql);

        }
        catch (Exception e) {
            return false;
        }
        finally {
            this.closeConnection(connection);
        }
    }

    public boolean SignIn(String id, String pwd) {
        Connection connection = null;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            String sql = "SELECT * from [dbo].[Users] WHERE cmuId = '" + id + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (resultSet.getString(5).equals(pwd)){
                    System.out.println("Logged in!");
                    return true;
                } else {
                    System.out.println(resultSet.getString(5));
                    return false;
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection(connection);
        }
        return false;
    }

    private void closeConnection(Connection connection) {
        try{
            if (connection != null && !connection.isClosed())
                connection.close();
        }
        catch(Exception e){
            // add error handling code
        }
    }
}

