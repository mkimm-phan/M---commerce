package com.mykimphan.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Calendar_Year_to_Lunar_YearActivity extends AppCompatActivity
implements View.OnClickListener
{

    EditText edtCalendarYear;
    Button btnLunarYear;
    TextView txtLunarYear;
    ImageView imgReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_year_to_lunar_year);
        addView();
        addEvents();
    }

    private void addEvents() {
        btnLunarYear.setOnClickListener(this);
        imgReturn.setOnClickListener(this);
    }

    private void addView() {
        edtCalendarYear=findViewById(R.id.edtCalendarYear);
        btnLunarYear=findViewById(R.id.btnLunarYear);
        txtLunarYear=findViewById(R.id.txtLunarYear);
        imgReturn=findViewById(R.id.imgReturn);
    }

    String convertCalendar2Lunar(int calendarYear)
    {
        String result="";
        String []arr_can={"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
        String []arr_chi={"Tý", "Sửu", "Dần", "Mẹo", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuat", "Hoi"};
        int can=calendarYear%10;
        String tenCan=arr_can[can];
        int chi=calendarYear%12;
        String tenChi=arr_chi[chi];
        result = tenCan + " " + tenChi;
        return result;
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnLunarYear)){
            // Convert c to l
            int caledarYear=Integer.parseInt(edtCalendarYear.getText().toString());
            String result=convertCalendar2Lunar(caledarYear);
            txtLunarYear.setText(result);
        }
        else if (v.equals(imgReturn)){
            finish();
        }
    }
}