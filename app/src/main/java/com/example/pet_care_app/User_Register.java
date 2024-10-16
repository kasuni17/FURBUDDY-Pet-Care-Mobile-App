package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class User_Register extends AppCompatActivity {
    EditText txtName,txtEmail,txtPass;
    DB_Helper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtName =findViewById(R.id.em_uname);
        txtEmail=findViewById(R.id.em_email);
        txtPass=findViewById(R.id.em_pw);
        db = new DB_Helper(this);
    }
    public void clear(){
        txtName.setText("");
        txtEmail.setText("");
        txtPass.setText("");
    }
    public void insert_user(View view){
        try {
            User u=new User();
            String name=txtName.getText().toString();
            String email=txtEmail.getText().toString();
            String pass=txtPass.getText().toString();

            if (name.equals("") || email.equals("")|| pass.equals(""))
            {
                Toast.makeText(User_Register.this, "FILL THE INFORMATION", Toast.LENGTH_SHORT).show();

            } else {
                u.setName(name);
                u.setEmail(email);
                u.setPass(pass);

                try {
                    db.insertUser(u);
                    Toast.makeText(this, "Registration Succesfull", Toast.LENGTH_SHORT).show();
                    clear();
                }catch (Exception e){
                    Toast.makeText(this, "Cannot Register", Toast.LENGTH_SHORT).show();
                    e.getStackTrace();
                }
            }

        }catch (Exception e){
            Toast.makeText(this, "Please Fill All the Details", Toast.LENGTH_SHORT).show();
        }


    }
    public void Emplog (View view){
        Intent Intent= new Intent(this,User_login.class);
        startActivity(Intent);
    }
}