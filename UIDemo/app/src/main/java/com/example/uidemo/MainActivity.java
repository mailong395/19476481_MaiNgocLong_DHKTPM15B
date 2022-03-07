package com.example.uidemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NhanVien> nv_List = new ArrayList<NhanVien>();
    MyArrayAdapter myArrayAdapter = null;
    String[] dv_List;
    String donvi;
    ImageView iv_Avatar;
    int SELECT_IMAGE_CODE = 1;
    Uri uri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_Avatar = findViewById(R.id.imageView_Avatar);
        Button bt_ChonHinh = findViewById(R.id.button_ChonHinh);

        EditText et_MaSo = findViewById(R.id.editText_NhapMa);
        EditText et_HoVaTen = findViewById(R.id.editText_NhapHoVaTen);
        RadioGroup rg_GioiTinh = findViewById(R.id.radioGroup_GioiTinh);

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

        ListView lv_NhanVien = findViewById(R.id.listView_NhanVien);
        myArrayAdapter = new MyArrayAdapter(this, R.layout.activity_my_item_layout, nv_List);
        lv_NhanVien.setAdapter(myArrayAdapter);

        Button bt_Them = findViewById(R.id.button_Them);
        bt_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maso = Integer.parseInt(et_MaSo.getText().toString());
                String hoten = et_HoVaTen.getText().toString();
                String gioitinh = ((RadioButton) findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString();

                // Tạo đối tượng nhân viên
                NhanVien nv = new NhanVien(maso, hoten, gioitinh, donvi, uri);

                // Thêm Nhân viên vào danh sách
                nv_List.add(nv);

                // Đưa danh sách nhân viên vào ListView
//                ArrayList<String> listItem = new ArrayList<>();
//                for (NhanVien nv1 :
//                        nv_List) {
//                    listItem.add(nv1.toString());
//                    MyArrayAdapter adapter1 = new MyArrayAdapter(MainActivity.this, R.layout.activity_my_item_layout, nv_List);
//                    lv_NhanVien.setAdapter(adapter1);
//                }

                myArrayAdapter.notifyDataSetChanged();
            }
        });

        Button btn_Sua = findViewById(R.id.button_Sua);
        btn_Sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = lv_NhanVien.getChildCount() - 1; i >= 0; i--) {
                    View v = lv_NhanVien.getChildAt(i);
                    CheckBox chk = v.findViewById(R.id.checkBox_Item);
                    if (chk.isChecked()) {
                        int maso = Integer.parseInt(et_MaSo.getText().toString());
                        String hoten = et_HoVaTen.getText().toString();
                        String gioitinh = ((RadioButton) findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString();

                        // Tạo đối tượng nhân viên
                        NhanVien nv = new NhanVien(maso, hoten, gioitinh, donvi, uri);

                        nv_List.set(i, nv);
                    }
                }
                myArrayAdapter.notifyDataSetChanged();
            }
        });

        bt_ChonHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Title"), SELECT_IMAGE_CODE);
            }
        });

        Button btn_Thoat = findViewById(R.id.button_Thoat);
        btn_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1) {
            uri = data.getData();
            iv_Avatar.setImageURI(uri);
        }
    }
}