package com.example.water.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private static final int REFRESH_SCREEN = 1;
    String names, lastnames, passwords, url, gender ,emails,tels;
    String GET_URL, SENT_URL;
    Button button_login;
    Button button_register;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText name, lastname,password, email, tel;
    private ListView dataView;
    private List<String> items;
    private ArrayAdapter<String> adt;
    private MySQLConnect mySQLConnect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        update();

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySQLConnect.sentData(name.getText().toString());
                items.add(name.getText().toString());
                adt.notifyDataSetChanged();

                mySQLConnect.sentData(lastname.getText().toString());
                items.add(lastname.getText().toString());
                adt.notifyDataSetChanged();

                mySQLConnect.sentData(password.getText().toString());
                items.add(password.getText().toString());
                adt.notifyDataSetChanged();

                int selectgender = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectgender);
                mySQLConnect.sentData(radioButton.getText().toString());
                items.add(radioButton.getText().toString());
                adt.notifyDataSetChanged();

                mySQLConnect.sentData(email.getText().toString());
                items.add(email.getText().toString());
                adt.notifyDataSetChanged();

                mySQLConnect.sentData(tel.getText().toString());
                items.add(tel.getText().toString());
                adt.notifyDataSetChanged();


            }
        });
    }
    public void update(){
        items = mySQLConnect.getData();
        adt = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, items);
        dataView.setAdapter(adt);
    }
    public void init() {
        name = (EditText)findViewById(R.id.name);
        lastname = (EditText)findViewById(R.id.lastname);
        password = (EditText)findViewById(R.id.password);
        int selectgender = radioGroup.getCheckedRadioButtonId();
        radioGroup = findViewById(R.id.radio);
        radioButton = findViewById(selectgender);
        button_login = (Button)findViewById(R.id.button_login);
        dataView = (ListView)findViewById(R.id.dataView);
        mySQLConnect = new MySQLConnect( RegisterActivity.this);
    }
}