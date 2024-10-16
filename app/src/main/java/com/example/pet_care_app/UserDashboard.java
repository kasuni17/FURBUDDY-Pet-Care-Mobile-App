package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class UserDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
    }
    public void view(View view){
        Intent Intent= new Intent(this,JobList.class);
        startActivity(Intent);
    }
    public void feedback(View view){
        Intent Intent= new Intent(this,ReviewPage.class);
        startActivity(Intent);
    }
    public void inserthouse(View view){
        Intent Intent= new Intent(this, Pet_Details.class);
        startActivity(Intent);
    }
}