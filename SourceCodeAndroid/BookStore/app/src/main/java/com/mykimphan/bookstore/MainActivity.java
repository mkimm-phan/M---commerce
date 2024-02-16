package com.mykimphan.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenRatingBookActivity(View view) {
        Intent intent=new Intent(MainActivity.this, RatingBookActivity.class);
        startActivity(intent);
    }

    public void OpenEventHandlingActivity(View view) {
        Intent intent=new Intent(MainActivity.this, EventHandlingActivity.class);
        startActivity(intent);
    }
}