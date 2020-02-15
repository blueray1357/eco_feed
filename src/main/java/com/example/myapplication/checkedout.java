package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class checkedout extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkedout);
        Button goback3 = findViewById(R.id.goback2);
        goback3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(checkedout.this,activity_feed.class);
        startActivity(intent);;
    }
}