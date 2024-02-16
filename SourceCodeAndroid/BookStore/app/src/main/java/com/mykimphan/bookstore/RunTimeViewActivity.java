package com.mykimphan.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class RunTimeViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_time_view);
    }

    public void drawButton(View view) {
        LinearLayout llButton=findViewById(R.id.llButton);
        int n=20;
        Random random = new Random();
        llButton.removeAllViews();

        for (int i=0; i<n; i++)
        {
            Button btn=new androidx.appcompat.widget.AppCompatButton(this){
//                @SuppressLint("ClickableViewAccessibility")
                @Override
                public boolean performClick()
                {
                    setTextColor(Color.RED);
                }
            };
        }
    }
}