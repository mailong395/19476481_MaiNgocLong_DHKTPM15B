package com.example.baitap_02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_TaiKhoan = findViewById(R.id.editText_TaiKhoan);
        EditText et_MatKhau = findViewById(R.id.editText_MatKhau);

        CheckBox cb_LuuThongTin = findViewById(R.id.checkBox_LuuThongTin);

        Button bt_DangNhap = findViewById(R.id.button_DangNhap);
        Button bt_Thoat = findViewById(R.id.button_Thoat);

        bt_DangNhap.setOnClickListener(view -> {
            if (cb_LuuThongTin.isChecked())
                Toast.makeText(MainActivity.this, "Chào mừng bạn đăng\n" +
                        "nhập hệ thống, thông tin của bạn đã được lưu", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MainActivity.this, "Chào mừng bạn\n" +
                        "đăng nhập hệ thống, thông tin của bạn không được lưu", Toast.LENGTH_LONG).show();
        });

        bt_Thoat.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Bạn có muốn thoát không?");
            builder.setTitle("Thông Báo");
            builder.setIcon(R.drawable.ic_launcher_foreground);
            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    finish();
                }
            });
            builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }
}