package com.example.lab04_ex2;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends Activity implements OnClickListener{

    Button btnread,btnwrite;
    EditText editdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnread=(Button) findViewById(R.id.Btn_ReadData);
        btnwrite=(Button) findViewById(R.id.Btn_WriteData);
        editdata=(EditText) findViewById(R.id.EditText_Data);
        btnread.setOnClickListener(this);
        btnwrite.setOnClickListener(this);
    }
    public void onClick(View v) {
        if(v.getId()==R.id.Btn_ReadData)
        {
            readData();
        }
        else if(v.getId()==R.id.Btn_WriteData)
        {
            writeData();
        }
    }

    public void readData()
    {
        try {
            FileInputStream in= openFileInput("File.txt");
            BufferedReader reader=new
                    BufferedReader(new InputStreamReader(in));
            String data="";
            StringBuilder builder=new StringBuilder();
            while((data=reader.readLine())!=null)
            {
                builder.append(data);
                builder.append("\n");
            }
            in.close();
            editdata.setText(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData()
    {
        try {
            FileOutputStream out=
                    openFileOutput("File.txt",0);
            OutputStreamWriter writer=
                    new OutputStreamWriter(out);
            writer.write(editdata.getText().toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData2() throws IOException {
        String data;
        InputStream inputStream = getAssets().open("File.txt");
        InputStreamReader inreader=new InputStreamReader(in);
        BufferedReader bufreader=new BufferedReader(inreader);
        StringBuilder builder=new StringBuilder();
        if(in!=null)
        {
            try{
                while((data=bufreader.readLine())!=null)
                {
                    builder.append(data);
                    builder.append("\n");
                }
                in.close();
                editdata.setText(builder.toString());
            }
            catch(IOException ex){
                Log.e("ERROR", ex.getMessage());
            }
        }
    }


//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }
}