package com.example.pet_care_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class caregiver_Log extends AppCompatActivity {
    EditText clusname , clpsword;
    Button clbtnlogin;
    Boolean clisLogged;
    DB_Helper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caregiver_log);
        clusname=findViewById(R.id.ad_uname);
        clpsword=findViewById(R.id.cl_pw);
        clbtnlogin=findViewById(R.id.btn_cl_lg);
        db =new DB_Helper(this);

        clbtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = clusname.getText().toString();
                String pass = clpsword.getText().toString();

                if (user.equals("") || pass.equals(""))
                {
                    Toast.makeText(caregiver_Log.this, "FILL THE INFORMATION", Toast.LENGTH_SHORT).show();

                } else {
                    Boolean result = db.checkcleannamepass(user, pass);

                    if (result==true) {
                        clisLogged=true;
                        Intent intent = new Intent(caregiver_Log.this, caregiverDASHBOARD.class);
                        intent.putExtra("Text", clisLogged);
                        intent.putExtra("usname",user);
                        startActivity(intent);
                        clear();

                    } else {
                        Toast.makeText(caregiver_Log.this, " WRONG CREDENTIALS", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void clear(){
        clusname.setText("");
        clpsword.setText("");
    }

    public void register (View view){
        Intent Intent= new Intent(this, caregiver_Reg.class);
        startActivity(Intent);
    }
}