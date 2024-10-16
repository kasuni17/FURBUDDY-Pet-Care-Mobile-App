package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class caregiverDASHBOARD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caregiver_dashboard);
    }
    public void viewjb(View view){
        Intent Intent= new Intent(this,JobList.class);
        startActivity(Intent);
    }
    public void feedbk(View view){
        Intent Intent= new Intent(this,ReviewPage.class);
        startActivity(Intent);
    }
}