package com.example.demolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ListView listView = findViewById(R.id.listview_traicay);
        // Lấy danh sách item string.xml
        listItems = getResources().getStringArray(R.array.traicay_array);
        // Sử dụng Adapter để lưu danh sách item và listView

        final ArrayAdapter adapter = new ArrayAdapter<> ( this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
        listView.setAdapter(adapter);
        // Phần sử lý
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = listItems[i];
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
            }
        });*/

        // Phần Spiner
        Spinner spinner = findViewById(R.id.spinner_traicay);
        listItems = getResources().getStringArray(R.array.traicay_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listItems);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = listItems[i];
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}