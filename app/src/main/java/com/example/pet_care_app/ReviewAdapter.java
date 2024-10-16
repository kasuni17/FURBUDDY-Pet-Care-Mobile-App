package com.example.pet_care_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ReviewAdapter extends BaseAdapter {
    TextView ReviewID, ReviewClname, ReviewEmname, ReviewContent;
    Context context;
    ArrayList<Review> reviews;

    public ReviewAdapter(Context context, ArrayList<Review> reviews) {
        this.context = context;
        this.reviews = reviews;
    }
    @Override
    public int getCount() {
        return reviews.size();
    }

    @Override
    public Object getItem(int i) {
        return reviews.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.activity_view_review,viewGroup,false);

        ReviewID=view1.findViewById(R.id.lblreviewID);
        ReviewClname=view1.findViewById(R.id.lblreviewClname);
        ReviewEmname=view1.findViewById(R.id.lblreviewEmname);
        ReviewContent=view1.findViewById(R.id.lblreviewContent);


        Review review= reviews.get(i);
        ReviewID.setText("RID: "+review.getRid());
        ReviewClname.setText("CLNAME: "+review.getClname());
        ReviewEmname.setText("EMNAME: "+review.getEmname());
        ReviewContent.setText("CONTENT: "+review.getContent());
        return view1;
    }
}

