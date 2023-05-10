package com.example.lab04_ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab04_ex2.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity1 extends AppCompatActivity {

    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


                // Initialize the views
                editText = findViewById(R.id.EditText_Data);
                button = findViewById(R.id.Btn_ReadData);

                // Set the click listener for the button
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Read the contents of the file and display them in the EditText view
                        String fileContents = readFromFile("File.txt");
                        editText.setText(fileContents);
                    }
                });
            }


            private String readFromFile(String fileName) {
                String fileContents = "";
                try {
                    InputStream inputStream = getAssets().open("File.txt");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) break;
                    {
                        fileContents += line;
                    }
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return fileContents;
            }
        }