package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ReviewPage extends AppCompatActivity {
    ArrayList<Review> reviews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_page);
        DB_Helper db = new DB_Helper(this);
        ListView reviewList = findViewById(R.id.lstReview);
        reviews= db.viewAllReviews();
        try {
            ReviewAdapter adapter= new ReviewAdapter(this,reviews);
            reviewList.setAdapter(adapter);
        }catch (Exception e){
            Toast.makeText(ReviewPage.this, "NO Products Available", Toast.LENGTH_SHORT).show();
        }
    }
    public void reviewpage(View view){
        Intent Intent= new Intent(this,insertReview.class);
        startActivity(Intent);
    }
}