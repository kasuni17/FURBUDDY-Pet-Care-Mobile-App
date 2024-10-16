package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewPetDetails extends AppCompatActivity {
    ArrayList<Pet> pets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);
        DB_Helper db = new DB_Helper(this);
        ListView HouseList = findViewById(R.id.jblist);
        pets = db.viewAllPet();
        try {
            PetAdapter adapter= new PetAdapter(this, pets);
            HouseList.setAdapter(adapter);
        }catch (Exception e){
            Toast.makeText(ViewPetDetails.this, "NO Products Available", Toast.LENGTH_SHORT).show();
        }
    }
    public void Reviews(View view){
        Intent Intent= new Intent(this,insertReview.class);
        startActivity(Intent);
    }
    public void accept(View view){
        Toast.makeText(this, "Job Accepted", Toast.LENGTH_SHORT).show();
    }
}