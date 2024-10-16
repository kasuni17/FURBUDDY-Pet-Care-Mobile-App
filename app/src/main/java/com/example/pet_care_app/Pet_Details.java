package com.example.pet_care_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Pet_Details extends AppCompatActivity {
    EditText pid, Owner, Address, Contact, sex, bread, Floor, Price,SFeet;
    ImageView image;
    DB_Helper db;
    byte[] imageByte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);
        pid = findViewById(R.id.HID);
        Owner = findViewById(R.id.Pet_Owner);
        Address = findViewById(R.id.Pet_Add);
        Contact = findViewById(R.id.Pet_Contact);
        sex = findViewById(R.id.rmnum);
        bread = findViewById(R.id.bthrmnumber);
        Floor = findViewById(R.id.fcount);
        SFeet = findViewById(R.id.sfcount);

        image = findViewById(R.id.Pet_Img);

        db = new DB_Helper(this);
    }

    public void clear() {
        pid.setText(null);
        Owner.setText(null);
        Address.setText(null);
        Contact.setText(null);
        sex.setText(null);
        SFeet.setText(null);
        bread.setText(null);
        Floor.setText(null);
        Price.setText(null);
        image.setImageBitmap(null);
        pid.requestFocus();
    }

    public void cleartxt(View view) {
        clear();
    }

    public void selectImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("crop", true);
        intent.putExtra("aspectX", 0);
        intent.putExtra("aspectY", 0);
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(Intent.createChooser(intent, "Select Product Name"), 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (data != null) {
                Uri uri = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 0, arrayOutputStream);
                    imageByte = arrayOutputStream.toByteArray();
                    image.setImageBitmap(bitmap);
                } catch (IOException ex) {
                    Log.e("Error ->", ex.getMessage());
                }
            }
        }
    }

    public void priceCal(View view) {
        int Sfeets;
        try {
            Sfeets = Integer.parseInt(SFeet.getText().toString());
            try {
                int finalP = Sfeets * 50 ;
                Log.i("gg", String.valueOf(finalP));
                Price.setText(String.valueOf(finalP));
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {

            }
        } catch (Exception e) {
            Toast.makeText(this, "Please enter a valid number for Square Feet", Toast.LENGTH_SHORT).show();
        }

    }

    public void insertHouse(View view) {

        try {
            Pet pet = new Pet();
            pet.setHid(Integer.parseInt(pid.getText().toString()));
            pet.setOwner(Owner.getText().toString());
            pet.setAddress(Address.getText().toString());
            pet.setContact(Integer.parseInt(Contact.getText().toString()));
            pet.setSex(Integer.parseInt(sex.getText().toString()));

            pet.setBread(Integer.parseInt(bread.getText().toString()));
            //pet.setColor(Floor.getText().toString());
            pet.setName(Integer.parseInt(Price.getText().toString()));
            pet.setImg(imageByte);
            try {
                if (db.insertPet(pet)>0) {
                    Toast.makeText(this, "Pet Inserted", Toast.LENGTH_SHORT).show();
                    clear();
                }
            } catch (Exception ex) {
                Log.e("Error -> ", ex.getMessage());
                Toast.makeText(this, "Please fill all the details correctly", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Toast.makeText(this, "Please fill all the details correctly", Toast.LENGTH_SHORT).show();
        }

    }

    public void findH(View view) {
        try {
            Pet pet = new Pet();
            pet.setHid(Integer.parseInt(pid.getText().toString()));
            try {
                pet = db.findPet(pet);
                if (pet != null) {
                    pid.setText(String.valueOf(pet.getPid()));
                    Owner.setText(pet.getOwner());
                    Address.setText(pet.getAddress());
                    Contact.setText(String.valueOf(pet.getContact()));
                    sex.setText(String.valueOf(pet.getSex()));
                    bread.setText(String.valueOf(pet.getBread()));
                    Floor.setText(pet.getColor());
                    Price.setText(String.valueOf(pet.getName()));
                    Bitmap bitmap = BitmapFactory.decodeByteArray(pet.getImg(), 0, pet.getImg().length);
                    image.setImageBitmap(bitmap);

                } else {
                    Toast.makeText(this, "Record not found", Toast.LENGTH_SHORT).show();
                    clear();
                }
            } catch (Exception ex) {
                Log.e("Error -> ", ex.getMessage());
            }
        } catch (Exception e) {
            Toast.makeText(this, "Please Provide a ID", Toast.LENGTH_SHORT).show();
            clear();
        }

    }

    public void updateH(View view) {
        try {
            Pet pet = new Pet();

            pet.setOwner(Owner.getText().toString());
            pet.setAddress(Address.getText().toString());
            pet.setContact(Integer.parseInt(Contact.getText().toString()));
            pet.setSex(Integer.parseInt(sex.getText().toString()));
            pet.setBread(Integer.parseInt(bread.getText().toString()));
            pet.setColor(Floor.getText().toString());
            pet.setName(Integer.parseInt(Price.getText().toString()));
            pet.setImg(imageByte);

            try {
                db.updatePet(pet);
                Toast.makeText(this, "Record Updated", Toast.LENGTH_SHORT).show();
                clear();
            } catch (Exception ex) {
                Log.e("Error -> ", ex.getMessage());
            }
        } catch (Exception e) {
            Toast.makeText(this, "Please provide all the details", Toast.LENGTH_SHORT).show();

        }


    }

    public void deleteH(View view) {
        Pet pet = new Pet();
        pet.setHid(Integer.parseInt(pid.getText().toString()));
        try {
            db.deletePet(pet);
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
            clear();
        } catch (Exception ex) {
            Log.e("Error -> ", ex.getMessage());
        }
    }
    public void viewadd(View view){
            Intent Intent= new Intent(this, ViewPetDetails.class);
        startActivity(Intent);
    }
}