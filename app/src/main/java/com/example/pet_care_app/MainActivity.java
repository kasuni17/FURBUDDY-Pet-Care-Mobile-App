package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OpenHome(View view){
        Intent Intent= new Intent(MainActivity.this,HomePage.class);
        startActivity(Intent);
    }
}