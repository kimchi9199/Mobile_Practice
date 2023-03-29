package com.example.lab02_ex1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView=(ImageView) findViewById(R.id.imageView);
        registerForContextMenu(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater im=getMenuInflater();
        im.inflate(R.menu.option_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(MainActivity.this,item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(MainActivity.this,item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;}

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater im= getMenuInflater();
        im.inflate(R.menu.context_menu, menu);
    }


}


