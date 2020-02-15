package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button ret = findViewById(R.id.back);
        ret.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(menu.this, activity_feed.class);
        startActivity(intent);
        ;
    }
}
