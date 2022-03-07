package com.example.baitap_01;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context = null;
    ArrayList<NhanVien> myArr = null;
    int layoutId;

    public MyArrayAdapter(Activity context, int textViewResourceId, ArrayList<NhanVien> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.myArr = objects;
        this.layoutId = textViewResourceId;
    }

    public View getView(int position, View converView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        converView = inflater.inflate(layoutId, null);

        if (myArr.size() > 0 && position >= 0) {
            final TextView txtDisplay = (TextView) converView.findViewById(R.id.textView_Item);
            final NhanVien nv = myArr.get(position);
            txtDisplay.setText(nv.toString());
            final ImageView imgItem = (ImageView) converView.findViewById(R.id.imageView_Item);
            if (nv.isGender())
                imgItem.setImageResource(R.drawable.iconboy);
            else
                imgItem.setImageResource(R.drawable.icongirl);
        }

        return converView;
    }
}
