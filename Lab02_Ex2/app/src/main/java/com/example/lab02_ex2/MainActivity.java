package com.example.lab02_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private RadioButton btn1, btn2, btn3, btn4;
    private LinearLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn_red);
        btn2 = findViewById(R.id.btn_green);
        btn3 = findViewById(R.id.btn_blue);
        btn4 = findViewById(R.id.btn_grey);
        bg = findViewById(R.id.bg);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg.setBackgroundColor(Color.RED);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg.setBackgroundColor(Color.GREEN);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg.setBackgroundColor(Color.BLUE);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg.setBackgroundColor(Color.GRAY);
            }
        });

    }

}
