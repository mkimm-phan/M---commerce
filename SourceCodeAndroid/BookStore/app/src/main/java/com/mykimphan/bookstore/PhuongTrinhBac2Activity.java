package com.mykimphan.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PhuongTrinhBac2Activity extends AppCompatActivity {

    EditText edtHsa, edtHsb, edtHsc;
    Button btnGiai, btnVe, btnTiep;
    TextView txtKetQua;
    View.OnClickListener myOnclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phuong_trinh_bac2);
        addview();
        addEvent();
    }

    private void addEvent() {
        myOnclick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()==R.id.btnVe)
                {
                    finish();
                } else if (view.getId()==R.id.btnTiep) {
                    edtHsa.setText("");
                    edtHsb.setText("");
                    edtHsc.setText("");
                    txtKetQua.setText("");
                    edtHsa.requestFocus();
                } else if (view.getId()==R.id.btnGiai) {
                    giaiPhuongTrinh();
                }
            }
        };

        btnGiai.setOnClickListener(myOnclick);
        btnTiep.setOnClickListener(myOnclick);
        btnVe.setOnClickListener(myOnclick);
    }

    private void giaiPhuongTrinh() {
        double hsa=Double.parseDouble(edtHsa.getText().toString());
        double hsb=Double.parseDouble(edtHsb.getText().toString());
        double hsc=Double.parseDouble(edtHsc.getText().toString());
        if (hsa==0)
        {
            if (hsb==0 && hsc==0){
                txtKetQua.setText("Vo So Nghiem");
            } else if (hsb==0 && hsc!=0) {
                txtKetQua.setText("Vo nghiem");
            }
            else {
                double x=-hsc/hsb;
                txtKetQua.setText("X="+x);
            }
        }
        else //ptb2
        {
            double delta=Math.pow(hsb,2)-4*hsa*hsc;
            if (delta<0){
                txtKetQua.setText("Vo Nghiem");
            } else if (delta==0) {
                double x=-hsb/(2*hsa);
                txtKetQua.setText("Nghiem kep x1 = x2 ="+x);
            }
            else {
                double x1 = (-hsb-Math.sqrt(delta))/(2*hsa);
                double x2 = (-hsb+Math.sqrt(delta))/(2*hsa);
                txtKetQua.setText("X1="+x1+";"+"X2="+x2);
            }
        }
    }

    private void addview() {
        edtHsa = findViewById(R.id.edtHsa);
        edtHsb = findViewById(R.id.edtHsb);
        edtHsc = findViewById(R.id.edtHsc);
        btnGiai = findViewById(R.id.btnGiai);
        btnTiep = findViewById(R.id.btnTiep);
        btnVe = findViewById(R.id.btnVe);
        txtKetQua = findViewById(R.id.txtKetQua);
    }
}