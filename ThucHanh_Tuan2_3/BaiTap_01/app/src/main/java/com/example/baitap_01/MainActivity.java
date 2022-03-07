package com.example.baitap_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NhanVien> arrNhanVien = null;
    MyArrayAdapter adapter = null;
    ListView lvNhanVien = null;
    Button btn_DangNhap;
    ImageButton btnRemoveAll;
    EditText et_Ma, et_Ten;
    RadioGroup rg_Gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_DangNhap = findViewById(R.id.button_NhapNV);
        btnRemoveAll = findViewById(R.id.imageButton_item);
        et_Ma = findViewById(R.id.editeText_MaNV);
        et_Ten = findViewById(R.id.editeText_TenNV);
        rg_Gender = findViewById(R.id.radioGroup_GioiTinh);

        lvNhanVien = findViewById(R.id.listView_DSNhanVien);
        arrNhanVien = new ArrayList<NhanVien>();
        adapter = new MyArrayAdapter(this, R.layout.my_item_layout, arrNhanVien);
        lvNhanVien.setAdapter(adapter);

        btn_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyNhap();
            }

            private void xuLyNhap() {
                String ma = et_Ma.getText().toString();
                String ten = et_Ten.getText().toString();
                boolean gioiTinh = false;
                if (rg_Gender.getCheckedRadioButtonId() == R.id.radio_Nam) {
                    gioiTinh = true;
                }

                NhanVien nv = new NhanVien(ma, ten, gioiTinh);
                arrNhanVien.add(nv);
                adapter.notifyDataSetChanged();
                et_Ma.setText("");
                et_Ten.setText("");
                et_Ma.requestFocus();
            }
        });

        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXoa();
            }

            private void xuLyXoa() {
                for (int i = lvNhanVien.getChildCount() - 1; i >= 0; i--) {
                    View v = lvNhanVien.getChildAt(i);
                    CheckBox chk = v.findViewById(R.id.checkBox_Item);
                    if (chk.isChecked())
                        arrNhanVien.remove(i);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}