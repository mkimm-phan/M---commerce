package com.mykimphan.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtPassword;
    TextView txtMessage;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addControls();
        addView();
    }

    private void addView() {
        edtName= this.<EditText>findViewById(R.id.edtName);
        edtPassword= this.<EditText>findViewById(R.id.edtPassword);
        txtMessage= this.<TextView>findViewById(R.id.txtMessage);
    }

    private void addControls() {
        edtName = this.<EditText>findViewById(R.id.edtName);
        btnLogin= this.<Button>findViewById(R.id.btnLogin);
    }

    public void exitApp(View view) {
        finish();
    }

    public void detail(View view) {
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("Tui là Phan Thi My Kim");
    }

    public void Login(View view) {
        String Name = edtName.getText().toString();
        String Pwd = edtPassword.getText().toString();

        if (Name.equalsIgnoreCase("admin") && Pwd.equals("123")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else
        {
            // Alarm login failed
            txtMessage.setText("Login failed! Please check your account again!");
        }
    }
}