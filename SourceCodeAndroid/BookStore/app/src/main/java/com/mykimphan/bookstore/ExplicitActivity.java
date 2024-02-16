package com.mykimphan.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ExplicitActivity extends AppCompatActivity {

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        addViews();
        addEvents();
    }

    private void addEvents() {
    }

    private void addViews() {
    }

//    class myClassEvent implements View
//
//            .OnClickListener
//    {}
}