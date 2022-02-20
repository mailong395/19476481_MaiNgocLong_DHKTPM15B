package com.example.baitap_04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private TextView tv_Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ed_Name = findViewById(R.id.editText_Name);

        tv_Result = findViewById(R.id.textView_Result);

        ArrayList<String> myList = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        setListAdapter(adapter);

        Button btn_Nhap = findViewById(R.id.button_Nhap);
        btn_Nhap.setOnClickListener(view -> {
            myList.add(ed_Name.getText().toString());
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        tv_Result.setText("Position: " + position + "; Value: " + item);
    }
}