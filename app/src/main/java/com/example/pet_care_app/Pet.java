package com.example.pet_care_app;

public class Pet {
    private static int hid;
    private static String owner;
    private static String address;
    private static int contact;
    private static int rooms;
    private static int bathrooms;
    private static int squearfeet;
    private static String flooring;
    private static int price;
    static byte[] img;

    public static int getPid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public static String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public static String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public static int getSex() {
        return rooms;
    }

    public void setSex(int rooms) {
        this.rooms = rooms;
    }

    public static int getFeet() {
        return squearfeet;
    }

    public void setFeet(int feet) {
        this.squearfeet = feet;
    }

    public static int getBread() {
        return bathrooms;
    }

    public void setBread(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public static String getColor() {
        return flooring;
    }

    public void setColor(String flooring) {
        this.flooring = flooring;
    }

    public static byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public static int getName() {
        return price;
    }

    public static void setName(int price) {
        Pet.price = price;
    }
}
