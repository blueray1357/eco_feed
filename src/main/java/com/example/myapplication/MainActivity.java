package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button create_feed = findViewById(R.id.create_feed);
        Button feed = findViewById(R.id.feed);

        create_feed.setOnClickListener(this);
        feed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.create_feed:
                intent = new Intent(MainActivity.this,Create_Feed.class);
                startActivity(intent);
                break;

            case R.id.feed:
                intent = new Intent(MainActivity.this,activity_feed.class);
                startActivity(intent);
                break;

        }

    }
}
