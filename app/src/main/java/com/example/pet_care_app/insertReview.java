package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class insertReview extends AppCompatActivity {
    EditText txtclname, txtemname, txtcontent ;
    DB_Helper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_review);
        txtclname =findViewById(R.id.re_clname);
        txtemname=findViewById(R.id.re_uname);
        txtcontent=findViewById(R.id.re_review);
        db =new DB_Helper(this);
    }
    public void insert_Reviews(View view){
        try {
            Review review=new Review();
            String clname=txtclname.getText().toString();
            String emname=txtemname.getText().toString();
            String content=txtcontent.getText().toString();

            if (clname.equals("") || emname.equals("")|| content.equals(""))
            {
                Toast.makeText(insertReview.this, "FILL THE INFORMATION", Toast.LENGTH_SHORT).show();

            } else {

                review.setClname(clname);
                review.setEmname(emname);
                review.setContent(content);

                try {
                    db.insertReviews(review);
                    Toast.makeText(this, "Review Sent Successfully", Toast.LENGTH_SHORT).show();
                    clear();
                }catch (Exception e){
                    Toast.makeText(this, "Please Check the details", Toast.LENGTH_SHORT).show();
                    e.getStackTrace();
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "Please Fill All the Details", Toast.LENGTH_SHORT).show();
        }


    }
    public void Reviewslist(View view){
        Intent Intent= new Intent(this,ReviewPage.class);
        startActivity(Intent);
    }
    public void clear(){
        txtclname.setText("");
        txtemname.setText("");
        txtcontent.setText("");
    }
}