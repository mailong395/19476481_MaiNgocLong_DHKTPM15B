package com.example.uidemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context = null;
    int SELECT_IMAGE_CODE = 1;
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
//                imgItem.setImageURI(nv.getUri());
        }
        return converView;
    }
}
