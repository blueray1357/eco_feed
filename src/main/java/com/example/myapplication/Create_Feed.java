package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Create_Feed extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_feed);
        Button createFeed = findViewById(R.id.cf);
        createFeed.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Create_Feed.this, activity_feed.class);
        startActivity(intent);
        ;
    }
}
