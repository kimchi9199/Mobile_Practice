package com.example.lab4_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button btnread, btnwrite;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnread= (Button) findViewById(R.id.btnreaddata);
        btnwrite = (Button) findViewById(R.id.btnwritedata);

        editText = (EditText) findViewById(R.id.editdata);
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream in= openFileInput("myfile.txt");
                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                    String data="";
                    StringBuilder builder=new StringBuilder();
                    while((data=reader.readLine())!=null){
                        builder.append(data);
                        builder.append("\n");
                    }
                    in.close();
                    editText.setText(builder.toString());
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream out=openFileOutput("myfile.txt",0);
                    OutputStreamWriter writer=new OutputStreamWriter(out);
                    writer.write(editText.getText().toString());
                    writer.close();
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    };
}

