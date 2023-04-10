package com.example.lab02_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public Button btn_finish;
    public EditText txtName,txtEmail,txtProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.nameKey);
        txtEmail = findViewById(R.id.emailKey);
        txtProject = findViewById(R.id.projectKey);

        btn_finish = findViewById(R.id.finish);

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent iGetContactInfo = new Intent(getApplicationContext(),ViewContactInfoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nameKey", txtName.getText().toString());
                    bundle.putString("emailKey", txtEmail.getText().toString());
                    bundle.putString("projectKey", txtProject.getText().toString());

                    iGetContactInfo.putExtras(bundle);
                    startActivities(new Intent[]{iGetContactInfo});

            }
        });
    }



}