package com.example.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NhanVien> nv_List = new ArrayList<NhanVien>();
    String[] dv_List;
    String donvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_MaSo = findViewById(R.id.editText_NhapMa);
        EditText et_HoVaTen = findViewById(R.id.editText_NhapHoVaTen);
        ListView lv_NhanVien = findViewById(R.id.listView_NhanVien);
        RadioGroup rg_GioiTinh = findViewById(R.id.radioGroup_GioiTinh);
        RadioButton rb_Nam = findViewById(R.id.radio_Nam);
        RadioButton rb_Nu = findViewById(R.id.radio_Nu);
        Spinner sp_DonVi = findViewById(R.id.spinner_DonVi);
        dv_List = getResources().getStringArray(R.array.donvi_List);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dv_List);
        sp_DonVi.setAdapter(adapter);
        sp_DonVi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donvi = dv_List[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Button bt_Them = findViewById(R.id.button_Them);
        bt_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maso = Integer.parseInt(et_MaSo.getText().toString());
                String hoten = et_HoVaTen.getText().toString();
                String gioitinh = ((RadioButton) findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString();

                // Tạo đối tượng nhân viên
                NhanVien nv = new NhanVien(maso, hoten, gioitinh, donvi);

                // Thêm Nhân viên vào danh sách
                nv_List.add(nv);

                // Đưa danh sách nhân viên vào ListView
                ArrayList<String> listItem = new ArrayList<>();
                for (NhanVien nv1 :
                        nv_List) {
                    listItem.add(nv1.toString());
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
                    lv_NhanVien.setAdapter(adapter1);
                }
            }
        });
    }
}