package com.example.pet_care_app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PetAdapter extends BaseAdapter {
    TextView PetID, PetOwner, PetAddress, Contact, Sex, Color, Bread;
    ImageView PetImage;


    Context context;
    ArrayList<Pet> pets;

    public PetAdapter(Context context, ArrayList<Pet> pets) {
        this.context = context;
        this.pets = pets;
    }

    @Override
    public int getCount() {
        return pets.size();
    }

    @Override
    public Object getItem(int i) {
        return pets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.activity_view_pet_details,viewGroup,false);

        PetID =view1.findViewById(R.id.insid);
        PetOwner =view1.findViewById(R.id.insname);
        PetAddress =view1.findViewById(R.id.insaddress);
        Contact =view1.findViewById(R.id.insnumber);
        Sex =view1.findViewById(R.id.lblhouseRooms);
        Color =view1.findViewById(R.id.lblhouseBathrooms);
        Bread =view1.findViewById(R.id.lblhouseFlooring);

        PetImage =view1.findViewById(R.id.hdimg);


        Pet pet = pets.get(i);
        PetID.setText("ID: "+ pet.getPid());
        PetOwner.setText("Owner: "+ pet.getOwner());
        PetAddress.setText("Address: "+ pet.getAddress());
        Contact.setText("Contact: "+ pet.getContact());
        Sex.setText("Rooms: "+ pet.getSex());
        Color.setText("Bathrooms: "+ pet.getBread());
        Bread.setText("Floring: "+ pet.getColor());


        Bitmap bitmap= BitmapFactory.decodeByteArray(pet.getImg(),0, pet.getImg().length);
        PetImage.setImageBitmap(bitmap);
        return view1;
    }
}
