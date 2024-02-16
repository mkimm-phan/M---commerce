package com.mykimphan.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EventHandlingActivity extends AppCompatActivity {

    Button btnChangeImg;
    ImageView imgStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handling);
        adview();
        addEvent();
    }

    private void addEvent() {
        btnChangeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgStudent.getTag()!=null)
                {
                    if (imgStudent.getTag().equals("men"))
                    {
                        imgStudent.setImageResource(R.mipmap.ic_women);
                        imgStudent.setTag("women");
                    }
                    else
                    {
                        imgStudent.setImageResource(R.mipmap.ic_men);
                        imgStudent.setTag("men");
                    }
                }
                else
                {
                    imgStudent.setImageResource(R.mipmap.ic_men);
                    imgStudent.setTag("men");
                }
            }
        });
    }

    private void adview() {
        btnChangeImg=findViewById(R.id.btnChangeImg);
        imgStudent=findViewById(R.id.imgStudent);
    }

    public void OpenVeribleActivity(View view) {
        Intent intent=new Intent(EventHandlingActivity.this, PhuongTrinhBac2Activity.class);
        startActivity(intent);
    }

    public void OpenCalendar2LunarActivity(View view) {
        Intent intent=new Intent(EventHandlingActivity.this, Calendar_Year_to_Lunar_YearActivity.class);
        startActivity(intent);
    }

    public void OnpenImagesSlideShowActivity(View view) {
        Intent intent=new Intent(EventHandlingActivity.this, ExplicitActivity.class );
        startActivity(intent);
    }

    public void OpenRunTimeViewActivity(View view) {
        Intent intent=new Intent(EventHandlingActivity.this, RunTimeViewActivity.class );
        startActivity(intent);
    }
}