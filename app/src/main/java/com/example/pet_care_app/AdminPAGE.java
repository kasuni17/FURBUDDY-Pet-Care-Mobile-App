package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AdminPAGE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
    }
    public void AdminReviews(View view){
        Intent Intent= new Intent(this,ReviewPage.class);
        startActivity(Intent);
    }
    public void petlist(View view){
        Intent Intent= new Intent(this,JobList.class);
        startActivity(Intent);
    }
}