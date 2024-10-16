package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class caregiver_Reg extends AppCompatActivity {
    EditText txtName,txtEmail,txtPass;
    DB_Helper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caregiver_reg);
        txtName =findViewById(R.id.ad_uname);
        txtEmail=findViewById(R.id.cl_email);
        txtPass=findViewById(R.id.cl_pw);
        db = new DB_Helper(this);
    }
    public void insert_caregiveruser(View view){
        try {
            caregiver caregiver =new caregiver();
            String name=txtName.getText().toString();
            String email=txtEmail.getText().toString();
            String pass=txtPass.getText().toString();

            if (name.equals("") || email.equals("")|| pass.equals(""))
            {
                Toast.makeText(caregiver_Reg.this, "FILL THE INFORMATION", Toast.LENGTH_SHORT).show();

            } else {
                caregiver.setName(name);
                caregiver.setEmail(email);
                caregiver.setPass(pass);

                try {
                    db.insertCleanUser(caregiver);
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    clear();
                }catch (Exception e){
                    Toast.makeText(this, "Cannot User_Register", Toast.LENGTH_SHORT).show();
                    e.getStackTrace();
                }
            }

        }catch (Exception e){
            Toast.makeText(this, "Please Fill All the Details", Toast.LENGTH_SHORT).show();
        }

    }
    public void clear(){
        txtName.setText("");
        txtEmail.setText("");
        txtPass.setText("");
    }
    public void caregiverlog(View view){
        Intent Intent= new Intent(this, caregiver_Log.class);
        startActivity(Intent);
    }
}


