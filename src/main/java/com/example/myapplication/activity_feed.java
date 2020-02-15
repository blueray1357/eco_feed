package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_feed extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        Button QRcode = findViewById(R.id.QRcode);
        Button friendlist = findViewById(R.id.friendlist);
        Button checkedout = findViewById(R.id.checkedout);
        Button menu = findViewById(R.id.menubutton);


        QRcode.setOnClickListener(this);
        friendlist.setOnClickListener(this);
        checkedout.setOnClickListener(this);
        menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.QRcode:
                intent = new Intent(activity_feed.this,scan.class);
                startActivity(intent);
                break;
            case R.id.friendlist:
                intent = new Intent(activity_feed.this,friends.class);
                startActivity(intent);
                break;
            case R.id.checkedout:
                intent = new Intent(activity_feed.this,checkedout.class);
                startActivity(intent);
                break;
            case R.id.menubutton:
                intent = new Intent(activity_feed.this,menu.class);
                startActivity(intent);
                break;

        }

    }
}
