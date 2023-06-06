package com.example.lab01_ex3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn=(Button) findViewById(R.id.buttonAlarm);
        final AlertDialog ad=new AlertDialog.Builder(this).create();
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Date t = new Date();
                String message="Thoi gian hien hanh" + t.toLocalString();
                ad.setMessage(message);
                ad.show();
            }
        });
    }



}