package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class User_login extends AppCompatActivity {
    EditText empusname , emppsword;
    Button empbtnlogin;
    Boolean isLogged;
    DB_Helper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        empusname = findViewById(R.id.ad_uname);
        emppsword = findViewById(R.id.cl_pw);
        empbtnlogin = findViewById(R.id.btn_cl_lg);
        db = new DB_Helper(this);
        empbtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = empusname.getText().toString();
                String pass = emppsword.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(User_login.this, "FILL THE INFORMATION", Toast.LENGTH_SHORT).show();

                } else {
                    Boolean result = db.checknamepass(user, pass);

                    if (result == true) {
                        isLogged = true;
                        Intent intent = new Intent(User_login.this, UserDashboard.class);
                        intent.putExtra("Text", isLogged);
                        intent.putExtra("usname", user);
                        startActivity(intent);
                        clear();

                    } else {
                        Toast.makeText(User_login.this, " WRONG CREDENTIALS", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public void clear(){
        empusname.setText("");
        emppsword.setText("");
    }

    public void register (View view){
        Intent Intent= new Intent(this, User_Register.class);
        startActivity(Intent);
    }
}