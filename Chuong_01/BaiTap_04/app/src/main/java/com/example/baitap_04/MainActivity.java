package com.example.baitap_04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_HoTen = findViewById(R.id.editText_HoTen);
        EditText et_CMND = findViewById(R.id.editText_CMND);
        EditText et_ThonTinBoSung = findViewById(R.id.editText_ThongTinBoSung);
        RadioGroup rg_BangCap = findViewById(R.id.radioGroup_BangCap);
        RadioButton rad_TrungCap = findViewById(R.id.radioButton_TrungCap);
        RadioButton rad_CaoDang = findViewById(R.id.radioButton_CaoDang);
        RadioButton rad_DaiHoc = findViewById(R.id.radioButton_DaiHoc);
        CheckBox cb_DocBao = findViewById(R.id.checkBox_DocBao);
        CheckBox cb_DocSach = findViewById(R.id.checkBox_DocSach);
        CheckBox cb_DocCoding = findViewById(R.id.checkBox_DocCoding);

        Button bt_GuiThongTin = findViewById(R.id.button_GuiThongTin);

        bt_GuiThongTin.setOnClickListener(view -> {
            int soLanCheck = 0;
            if (cb_DocBao.isChecked()) soLanCheck++;
            if (cb_DocSach.isChecked()) soLanCheck++;
            if (cb_DocCoding.isChecked()) soLanCheck++;

            if(!Pattern.matches("^[\\w\\s]{3,}$", et_HoTen.getText())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông Báo");
                builder.setMessage("Tên người không được để trống và phải có ít nhất 3 ký tự");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            } else if (!Pattern.matches("^[0-9]{9}$", et_CMND.getText())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông Báo");
                builder.setMessage("Chứng minh nhân dân chỉ được nhập kiểu số và phải có đúng 9 chữ số");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            } else if (soLanCheck == 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông Báo");
                builder.setMessage("Sở thích phải chọn ít nhất 1 chọn lựa");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            } else {
                // Truyền vào chuổi họ và tên
                String chuoiThongTin = "Họ và Tên: " + et_HoTen.getText().toString() + "\n";

                // Truyền vào chuổi CMND
                chuoiThongTin += "CMND: " + et_CMND.getText().toString() + "\n";

                // Truyền vào chuổi Bằng cấp
                int checkedRadio_BangCap = rg_BangCap.getCheckedRadioButtonId();
                if (checkedRadio_BangCap == R.id.radioButton_TrungCap)
                    chuoiThongTin += "Bằng cấp: " + rad_TrungCap.getText().toString() + "\n";
                else if (checkedRadio_BangCap == R.id.radioButton_CaoDang)
                    chuoiThongTin += "Bằng cấp: " + rad_CaoDang.getText().toString() + "\n";
                else if (checkedRadio_BangCap == R.id.radioButton_DaiHoc)
                    chuoiThongTin += "Bằng cấp: " + rad_DaiHoc.getText().toString() + "\n";

                // Truyển vào chuổi sở thích
                chuoiThongTin += "Sở thích:\n";
                if (cb_DocBao.isChecked()) chuoiThongTin += "\t" + cb_DocBao.getText().toString() + "\n";
                if (cb_DocSach.isChecked()) chuoiThongTin += "\t" + cb_DocSach.getText().toString() + "\n";;
                if (cb_DocCoding.isChecked()) chuoiThongTin += "\t" + cb_DocCoding.getText().toString() + "\n";;

                // Truyền vào chuổi thông tin bổ sung
                chuoiThongTin += "Thông tin bổ sung: " + et_ThonTinBoSung.getText();

                // Hiển thị thông tin
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông Báo");
                builder.setMessage(chuoiThongTin);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


    }
}