package com.example.baitap_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_NamDuong = findViewById(R.id.editText_NamDuong);
        TextView tv_NamAm = findViewById(R.id.textView_NamAm);
        Button bt_ChuyenDoi = findViewById(R.id.button_ChuyenDoi);

        bt_ChuyenDoi.setOnClickListener(view -> {
            int namDuong = Integer.parseInt(et_NamDuong.getText().toString());
            String namAm = getLichAm(namDuong);
            tv_NamAm.setText(namAm);
        });
    }

    public String getLichAm(int namDuong) {
        String namAm = "";
        int can = namDuong % 10;
        int chi =  namDuong % 12;
        switch (can) {
            case 0:
                namAm = "Canh";
                break;
            case 1:
                namAm = "Tân";
                break;
            case 2:
                namAm = "Nhâm";
                break;
            case 3:
                namAm = "Quý";
                break;
            case 4:
                namAm = "Giáp";
                break;
            case 5:
                namAm = "Ất";
                break;
            case 6:
                namAm = "Bính";
                break;
            case 7:
                namAm = "Đinh";
                break;
            case 8:
                namAm = "Mậu";
                break;
            case 9:
                namAm = "kỷ";
                break;
        }

        switch (chi) {
            case 0:
                namAm = namAm + " Thân";
                break;
            case 1:
                namAm = namAm + " Dậu";
                break;
            case 2:
                namAm = namAm + " Tuất";
                break;
            case 3:
                namAm = namAm + " Hợi";
                break;
            case 4:
                namAm = namAm + " Tý";
                break;
            case 5:
                namAm = namAm + " Sửu";
                break;
            case 6:
                namAm = namAm + " Dần";
                break;
            case 7:
                namAm = namAm + " Mẹo";
                break;
            case 8:
                namAm = namAm + " Thìn";
                break;
            case 9:
                namAm = namAm + " tỵ";
                break;
            case 10:
                namAm = namAm + " Ngọ";
                break;
            case 11:
                namAm = namAm + " Mùi";
                break;
        }

        return namAm;
    }
}