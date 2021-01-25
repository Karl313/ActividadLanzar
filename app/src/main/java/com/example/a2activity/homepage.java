package com.example.a2activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class homepage extends AppCompatActivity {
private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        tv1=findViewById(R.id.tv1);


        Bundle b = getIntent().getExtras();

        tv1.setText(b.getString("user"));









    }
}