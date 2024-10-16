package com.example.pet_care_app;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB_Helper extends SQLiteOpenHelper {
    public DB_Helper(@Nullable Context context) {super(context, "pet_care_hub", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE tblUser (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME VARCHAR(20),EMAIL VARCHAR(20) , PSWORD VARCHAR(15))";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE tblCaregiver (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME VARCHAR(20),EMAIL VARCHAR(20) , PSWORD VARCHAR(15))";
        sqLiteDatabase.execSQL(sql);
        sql ="CREATE TABLE PET (HID INTEGER PRIMARY KEY, OWNER VARCHAR(25),ADDRESS VARCHAR(35),CONTACT INTEGER,ROOMS INTEGER," +
                "BATHROOMS INTEGER,FLOORING VARCHAR(20),PRICE INTEGER, IMG BLOG)";
        sqLiteDatabase.execSQL(sql);
        sql ="CREATE TABLE REVIEWS (RID INTEGER PRIMARY KEY AUTOINCREMENT , CLNAME VARCHAR(20),EMNAME VARCHAR(20),CONTENT VARCHAR(70))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS tblUser";
        sqLiteDatabase.execSQL(sql);
        sql = "DROP TABLE IF EXISTS tblCaregiver";
        sqLiteDatabase.execSQL(sql);
        sql = "DROP TABLE IF EXISTS PET";
        sqLiteDatabase.execSQL(sql);
        sql = "DROP TABLE IF EXISTS REVIEWS";
        sqLiteDatabase.execSQL(sql);
    }


    public void insertUser(User u) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO tblUser (NAME,EMAIL,PSWORD) VALUES ('" + u.getName() + "', '" + u.getEmail() + "', '" + u.getPass() + "')";
        db.execSQL(sql);
    }
    public void insertCleanUser(caregiver caregiver) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO tblCaregiver (NAME,EMAIL,PSWORD) VALUES ('" + caregiver.getName() + "', '" + caregiver.getEmail() + "', '" + caregiver.getPass() + "')";
        db.execSQL(sql);
    }
    public Boolean checknamepass(String NAME, String PASS) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select*from tblUser where NAME = ? and PSWORD = ?", new String[]{NAME,PASS});
        if (cursor.getCount() > 0) {

            return true;
        } else {
            return false;
        }


    }

    public Boolean checkcleannamepass(String NAME, String PASS) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select*from tblCaregiver where NAME = ? and PSWORD = ?", new String[]{NAME,PASS});
        if (cursor.getCount() > 0) {

            return true;
        } else {
            return false;
        }


    }
    public long insertPet(Pet pet){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("PID", Pet.getPid());
        values.put("OWNER", Pet.getOwner());
        values.put("ADDRESS", Pet.getAddress());
        values.put("CONTACT", Pet.getContact());
        values.put("SEX", Pet.getSex());
        values.put("BREAD", Pet.getBread());
        values.put("COLOR", Pet.getColor());
        values.put("NAME", Pet.getName());
        values.put("IMG", Pet.getImg());
        return db.insert("PET ",null,values);
    }

    public int updatePet(Pet pet){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("OWNER", Pet.getOwner());
        values.put("ADDRESS", Pet.getAddress());
        values.put("CONTACT", Pet.getContact());
        values.put("SEX", Pet.getSex());
        values.put("BREAD", Pet.getBread());
        values.put("COLOR", Pet.getColor());
        values.put("NAME", Pet.getName());
        values.put("IMG", Pet.getImg());
        return db.update("PET",values,"HID ="+ pet.getPid(),null);

    }

    public void deletePet(Pet pet){
        SQLiteDatabase db = getWritableDatabase();
        String sql ="DELETE FROM PET WHERE HID="+ pet.getPid();
        db.execSQL(sql);
    }
    @SuppressLint("Range")
    public Pet findPet(Pet pet){
        String sql = "SELECT * FROM PET WHERE HID="+ pet.getPid();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        int count=cursor.getCount();
        Pet pet1 = new Pet();
        if (count!=0){
            if (cursor.moveToFirst()) {
                pet1.setHid(Integer.parseInt(cursor.getString(cursor.getColumnIndex("HID"))));
                pet1.setOwner(cursor.getString(cursor.getColumnIndex("OWNER")));
                pet1.setAddress(cursor.getString(cursor.getColumnIndex("ADDRESS")));
                pet1.setContact(Integer.parseInt(cursor.getString(cursor.getColumnIndex("CONTACT"))));
                pet1.setSex(Integer.parseInt(cursor.getString(cursor.getColumnIndex("SEX"))));
                pet1.setBread(Integer.parseInt(cursor.getString(cursor.getColumnIndex("BREAD"))));
                pet1.setColor(cursor.getString(cursor.getColumnIndex("COLOR")));
                pet1.setName(Integer.parseInt(cursor.getString(cursor.getColumnIndex("NAME"))));
                pet1.setImg(cursor.getBlob(cursor.getColumnIndex("IMG")));
            }
        }else {
            pet =null;
        }
        return pet;
    }

    public ArrayList<Pet> viewAllPet(){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM PET";
        Cursor cursor = db.rawQuery(sql,null);
        ArrayList<Pet> pets = new ArrayList<>();
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                Pet pet =new Pet();
                pet.setHid(cursor.getInt(0));
                pet.setOwner(cursor.getString(1));
                pet.setAddress(cursor.getString(2));
                pet.setContact(cursor.getInt(3));
                pet.setSex(cursor.getInt(4));
                pet.setBread(cursor.getInt(5));
                pet.setColor(cursor.getString(6));
                pet.setName(cursor.getInt(7));
                pet.setImg(cursor.getBlob(8));
                pets.add(pet);

            }

        }else{
            pets =null;
        }
        return pets;
    }
    public ArrayList<Review> viewAllReviews(){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM REVIEWS";
        Cursor cursor = db.rawQuery(sql,null);
        ArrayList<Review> reviews = new ArrayList<>();
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                Review review=new Review();
                review.setRid(cursor.getInt(0));
                review.setClname(cursor.getString(1));
                review.setEmname(cursor.getString(2));
                review.setContent(cursor.getString(3));
                reviews.add(review);
            }

        }else{
            reviews=null;
        }
        return reviews;
    }
    public void insertReviews(Review review) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO REVIEWS (CLNAME , EMNAME , CONTENT) VALUES " +
                "('" + review.getClname() + "', '" + review.getEmname() + "', '" + review.getContent() + "')";
        db.execSQL(sql);
    }
}
