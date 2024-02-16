package com.mykimphan.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class RatingBookActivity extends AppCompatActivity {

    RadioButton radGood;
    RadioButton radNormal;
    RadioButton radBad;
    TextView txtResultV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_book);
        addview();
    }

    private void addview() {
        radGood=findViewById(R.id.radGood);
        radNormal=findViewById(R.id.radNormal);
        radBad=findViewById(R.id.radBad);
        txtResultV=findViewById(R.id.txtResultV);
    }

    public void processVote(View view) {
        if (radGood.isChecked()){
            txtResultV.setText("You choose: "+radGood.getText().toString());
        } else if (radNormal.isChecked()) {
            txtResultV.setText("You choose: "+radNormal.getText().toString());
        } else if (radBad.isChecked()) {
            txtResultV.setText("You choose: "+radBad.getText().toString());
        }
    }

    public void goBack(View view) {
        finish();
    }
}