package com.example.baitap_06;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_Request = findViewById(R.id.textView_Request);

        ListView lv_Ten = findViewById(R.id.listView_Ten);

        Resources res = getResources();

        ArrayAdapter<String> arrayAdapter_Ten = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                res.getStringArray(R.array.listTen));

        lv_Ten.setAdapter(arrayAdapter_Ten);
        lv_Ten.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String rs = "Position: " + i + "; Value: " + adapterView.getItemAtPosition(i).toString();
                tv_Request.setText(rs);
            }
        });

    }
}