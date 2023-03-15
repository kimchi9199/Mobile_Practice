package com.example.lab01_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btncallPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncallPhone = findViewById(R.id.btnCall);

        //Click process
        btncallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // khai bao public Intent
                Intent myintent = new Intent(MainActivity.this, CallPhoneActivity.class);
                startActivity(myintent);

            }
        });
    }
}