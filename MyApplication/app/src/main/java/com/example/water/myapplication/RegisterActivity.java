package com.example.water.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private static final int REFRESH_SCREEN = 1;
    String name, lasname,password, url,gender,;
    String GET_URL, SENT_URL;
    Button button_login;
    Button button_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
