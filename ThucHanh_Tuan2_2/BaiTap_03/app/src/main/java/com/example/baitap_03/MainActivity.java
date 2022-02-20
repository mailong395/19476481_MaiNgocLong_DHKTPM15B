package com.example.baitap_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> myList;
    private ArrayAdapter<String> adapter;
    private ListView list;
    private Button btn_Nhap;
    private TextView tv_Result;
    private EditText ed_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_Name = findViewById(R.id.editText_Name);

        myList = new ArrayList<String>();

        list = findViewById(R.id.listView_ListName);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        list.setAdapter(adapter);

        tv_Result = findViewById(R.id.textView_Result);

        btn_Nhap = findViewById(R.id.button_Nhap);
        btn_Nhap.setOnClickListener(view -> {
            myList.add(ed_Name.getText().toString());
            adapter.notifyDataSetChanged();
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = "Position: " + i;
                msg += "; " + "Value: " + adapterView.getItemAtPosition(i).toString();

                tv_Result.setText(msg);
            }
        });

    }
}