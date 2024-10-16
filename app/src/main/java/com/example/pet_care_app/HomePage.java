package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }
    public void CleanerLog(View view){
        Intent Intent= new Intent(this, caregiver_Log.class);
        startActivity(Intent);
    }
    public void EmpLog(View view){
        Intent Intent= new Intent(this, User_login.class);
        startActivity(Intent);
    }
    public void AdminLog(View view){
        Intent Intent= new Intent(this,AdminLogin.class);
        startActivity(Intent);
    }
    public void ContactUs(View view){
        Intent Intent= new Intent(this,Contact_US.class);
        startActivity(Intent);
    }

}