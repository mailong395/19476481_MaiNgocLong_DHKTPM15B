package com.example.baitap_05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private EditText et_MaNV, et_TenNV;
    private RadioGroup rg_Loai;
    private Button btn_NhapNV;
    private ArrayList<NhanVien> listNV;
    private ArrayAdapter<NhanVien> adapterNV;
    private NhanVien nhanVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_MaNV = findViewById(R.id.editText_MaNV);
        et_TenNV = findViewById(R.id.editText_TenNV);
        rg_Loai = findViewById(R.id.radioGroup_Loai);
        btn_NhapNV = findViewById(R.id.button_NhapNV);
        listNV = new ArrayList<NhanVien>();
        adapterNV = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listNV);
        setListAdapter(adapterNV);
        btn_NhapNV = findViewById(R.id.button_NhapNV);
        btn_NhapNV.setOnClickListener(view -> {
            nhap();
        });
    }

    private void nhap() {
        int radId = rg_Loai.getCheckedRadioButtonId();
        String maNV = et_MaNV.getText().toString();
        String tenNV = et_TenNV.getText().toString();
        if (radId == R.id.radioButton_Chinhthuc)
            nhanVien = new NhanVienChinhThuc();
        else
            nhanVien = new NhanVienThoiVu();
        nhanVien.setMaNV(maNV);
        nhanVien.setTenNV(tenNV);
        listNV.add(nhanVien);
        adapterNV.notifyDataSetChanged();
    }
}