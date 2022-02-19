package com.example.baitap_01;

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

        EditText ed_SoA = findViewById(R.id.editText_SoA);
        EditText ed_SoB = findViewById(R.id.editText_SoB);
        TextView tv_KetQua = findViewById(R.id.textView_KetQua);
        Button bt_Tong = findViewById(R.id.button_Tong);
        Button bt_Hieu = findViewById(R.id.button_Hieu);
        Button bt_Tich = findViewById(R.id.button_Tich);
        Button bt_Thuong = findViewById(R.id.button_Thuong);
        Button bt_UCLN = findViewById(R.id.button_UCLN);
        Button bt_Thoat = findViewById(R.id.button_Thoat);

        bt_Tong.setOnClickListener(view -> {
            int soA = Integer.parseInt(ed_SoA.getText().toString());
            int soB = Integer.parseInt(ed_SoB.getText().toString());
            int rs = soA + soB;
            String output = "" + rs;
            tv_KetQua.setText(output);
        });
        bt_Hieu.setOnClickListener(view -> {
            int soA = Integer.parseInt(ed_SoA.getText().toString());
            int soB = Integer.parseInt(ed_SoB.getText().toString());
            int rs = soA - soB;
            String output = "" + rs;
            tv_KetQua.setText(output);
        });
        bt_Tich.setOnClickListener(view -> {
            int soA = Integer.parseInt(ed_SoA.getText().toString());
            int soB = Integer.parseInt(ed_SoB.getText().toString());
            int rs = soA * soB;
            String output = "" + rs;
            tv_KetQua.setText(output);
        });
        bt_Thuong.setOnClickListener(view -> {
            int soA = Integer.parseInt(ed_SoA.getText().toString());
            int soB = Integer.parseInt(ed_SoB.getText().toString());
            String output;
            if (soB == 0){
                output = "Số b = 0. không tính được!";
            } else {
                float rs = soA / (float) soB;
                output = "" + rs;
            }
            tv_KetQua.setText(output);
        });
        bt_UCLN.setOnClickListener(view -> {
            int soA = Integer.parseInt(ed_SoA.getText().toString());
            int soB = Integer.parseInt(ed_SoB.getText().toString());
            int rs = gcd(soA, soB);
            String output = "" + rs;
            tv_KetQua.setText(output);
        });
        bt_Thoat.setOnClickListener(view -> finish());
    }

    public int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
}