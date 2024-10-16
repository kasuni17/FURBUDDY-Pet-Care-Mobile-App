package com.example.pet_care_app;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Contact_US extends AppCompatActivity {
    EditText txtMobNum,txtMsg;
    TextView lblCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        txtMobNum=findViewById(R.id.Phone);
        txtMsg=findViewById(R.id.Msg);
        lblCount=findViewById(R.id.count);

        txtMsg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                lblCount.setText(charSequence.length()+"/160 left");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void sendSMS(View view){
        String number =txtMobNum.getText().toString();
        String msg = txtMsg.getText().toString();
//        if(number.isEmpty()&&msg.isEmpty()){
        SmsManager smsManager=SmsManager.getDefault();
        if (Build.VERSION.SDK_INT>=23){
            if (ContextCompat.checkSelfPermission(Contact_US.this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(Contact_US.this,new String[]{Manifest.permission.SEND_SMS},999);
            }
        }
        smsManager.sendTextMessage(number,null,msg,null,null);
        Toast.makeText(this, "Successfully Massage Sent", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
//        }
    }
}