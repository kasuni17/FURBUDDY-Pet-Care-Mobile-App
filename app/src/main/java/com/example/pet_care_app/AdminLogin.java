package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLogin extends AppCompatActivity {
    EditText txtAdminsUsername, txtAdminPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        txtAdminsUsername = findViewById(R.id.ad_uname);
        txtAdminPassword = findViewById(R.id.ad_pws);
    }

    public void AdminLog(View view) {
        try {
            if (txtAdminsUsername.getText().toString().equals("admin") && (txtAdminPassword.getText().toString().equals("1234"))) {
                Intent intent = new Intent(AdminLogin.this, AdminPAGE.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Wrong username or Password!!!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Please Provide All the details", Toast.LENGTH_SHORT).show();
        }
    }
}