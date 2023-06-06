package com.example.lab01_ex4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText usrInput = (EditText) findViewById(R.id.edt_text);
        final AlertDialog alert_dialog = new AlertDialog.Builder(this).create();
        usrInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
                    String message = usrInput.getText().toString();
                    alert_dialog.setMessage(message);
                    alert_dialog.show();
                    return true;
                }
                return false;
            }
        });
    }

}