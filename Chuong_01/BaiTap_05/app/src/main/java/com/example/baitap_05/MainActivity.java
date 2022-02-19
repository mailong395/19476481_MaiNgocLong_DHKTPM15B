package com.example.baitap_05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ed_HoTenKH = findViewById(R.id.editText_HoTenKH);
        EditText ed_SLSach = findViewById(R.id.editText_SoLuong);

        CheckBox cb_KhVip = findViewById(R.id.checkBox_KHVIP);

        TextView tv_ThanhTien = findViewById(R.id.textView_ThanhTien);

        Button bt_TinhTT = findViewById(R.id.button_TinhTT);

        List<KhachHang> listKH = new ArrayList<KhachHang>();

        bt_TinhTT.setOnClickListener(view -> {
            String hoTenKh = ed_HoTenKH.getText().toString();
            boolean vip = cb_KhVip.isChecked();
            if (!Pattern.matches("^[0-9-]{0,}$", ed_SLSach.getText().toString())) {
                Toast.makeText(MainActivity.this, "Chỉ co phép nhập dữ liệu số", Toast.LENGTH_LONG).show();
                ed_SLSach.requestFocus();
            } else {
                int soLuongSach = Integer.parseInt(ed_SLSach.getText().toString());
                KhachHang khachHang = new KhachHang(listKH.size() + "", hoTenKh, soLuongSach, vip);
                float thanhTien = 0;
                if (khachHang.isVip())
                    thanhTien = soLuongSach * 20000 * (float)0.9;
                else
                    thanhTien = soLuongSach * 20000;
                tv_ThanhTien.setText(thanhTien + "");
            }
        });
    }
}