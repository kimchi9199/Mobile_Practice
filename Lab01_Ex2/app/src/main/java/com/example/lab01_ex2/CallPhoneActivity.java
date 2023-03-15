 package com.example.lab01_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

 public class CallPhoneActivity extends AppCompatActivity {

    EditText editPhoneNumber;
    ImageButton imagebtnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);

        editPhoneNumber = findViewById((R.id.editPhoneNumber));
        imagebtnCall= findViewById(R.id.imagebtnCall);

        imagebtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent an
                Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+editPhoneNumber.getText().toString()));
                //need user accept
                if (ActivityCompat.checkSelfPermission(CallPhoneActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallPhoneActivity.this, new  String[]{android.Manifest.permission.CALL_PHONE},1);
                }
                startActivity(callintent);
            }
        });
    }
}