package com.example.lab02_ex4;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ViewContactInfoActivity extends MainActivity {
    TextView txtNameValue;
    TextView txtEmailValue;
    TextView txtProjectValue;

    Button finishBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.contact_information);

        txtNameValue = (TextView) findViewById(R.id.nameKey);
        txtEmailValue = (TextView) findViewById(R.id.emailKey);
        txtProjectValue = (TextView) findViewById(R.id.projectKey);

        finishBtn=(Button) findViewById(R.id.finish);
        finishBtn.setOnClickListener(ClickFinish);

        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("nameKey");
        String email=bundle.getString("emailKey");
        String project=bundle.getString("projectKey");

        txtNameValue.setText(name);
        txtEmailValue.setText(email);
        txtProjectValue.setText(project);
    }
    private View.OnClickListener ClickFinish = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}
