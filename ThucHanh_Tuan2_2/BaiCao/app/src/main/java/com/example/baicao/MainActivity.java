package com.example.baicao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    int[] mangHinhBai = new int[]{
            R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
            R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
            R.drawable.cj, R.drawable.cq, R.drawable.ck,
            R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5,
            R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9, R.drawable.d10,
            R.drawable.dj, R.drawable.dq, R.drawable.dk,
            R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5,
            R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,
            R.drawable.hj, R.drawable.hq, R.drawable.hk,
            R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5,
            R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9, R.drawable.s10,
            R.drawable.sj, R.drawable.sq, R.drawable.sk};;
    int soLanNhan = 1;
    int soLanNguoiThang = 0;
    int soLanNguoiHoa = 0;
    int soLanNguoiThua = 0;

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private ImageView iv5;
    private ImageView iv6;
    private TextView tv_ketquamay;
    private TextView tv_ketquanguoi;
    private TextView tv_NguoChienThang;
    private Button bt_rutLaBai;
    private Spinner spn_DoiThu;
    private EditText et_NhapThoiGian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.imageView1);
        iv2 = findViewById(R.id.imageView2);
        iv3 = findViewById(R.id.imageView3);
        iv4 = findViewById(R.id.imageView4);
        iv5 = findViewById(R.id.imageView5);
        iv6 = findViewById(R.id.imageView6);
        tv_ketquamay = findViewById(R.id.textView_KetQuaMay);
        tv_ketquanguoi = findViewById(R.id.textView_KetQuaNguoi);
        tv_NguoChienThang = findViewById(R.id.textView_NguoiChienThang);
        bt_rutLaBai= findViewById(R.id.button_rutlabai);
        spn_DoiThu = findViewById(R.id.spinner_DoiThu);
        et_NhapThoiGian = findViewById(R.id.editText_NhapThoiGian);

        List<String> listDoiThu = new ArrayList<String>();
        listDoiThu.add("Chơi với người");
        listDoiThu.add("Chơi với máy");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listDoiThu);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spn_DoiThu.setAdapter(adapter);

        spn_DoiThu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, spn_DoiThu.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bt_rutLaBai.setOnClickListener(view -> {
            if (spn_DoiThu.getSelectedItemPosition() == 0) {
                ChiaBai();
                soLanNhan++;
                if (soLanNhan % 10 == 0) {
                    ketQuaChungCuoc();
                    soLanNguoiThua = soLanNguoiThang = soLanNguoiHoa = 0;
                }
            } else {
                int thoiGian = 10000;
                if (Pattern.matches("[0-9]{1,}]", et_NhapThoiGian.getText().toString())) {
                    thoiGian = Integer.parseInt(et_NhapThoiGian.getText().toString());
                }
                else {
                    Toast.makeText(MainActivity.this, "Yêu cầu nhập lại", Toast.LENGTH_SHORT).show();
                    et_NhapThoiGian.requestFocus();
                }

                new CountDownTimer(thoiGian, 2000) {
                    @Override
                    public void onTick(long l) {
                        ChiaBai();
                    }

                    @Override
                    public void onFinish() {
                        ketQuaChungCuoc();
                    }
                }.start();
            }


        });

    }

    private void ketQuaChungCuoc() {
        String kqcc = "";
        if (soLanNguoiThang == soLanNguoiThua) {
            kqcc += "Hòa\nNgười thắng: " + soLanNguoiThang + "\nMáy thắng: " + soLanNguoiThua;
            Toast.makeText(MainActivity.this, kqcc, Toast.LENGTH_LONG).show();
        }
        else if (soLanNguoiThang > soLanNguoiThua) {
            kqcc += "Người chơi thắng\nNgười thắng: " + soLanNguoiThang + "\nMáy thắng: " + soLanNguoiThua;
            Toast.makeText(MainActivity.this, kqcc, Toast.LENGTH_LONG).show();
        }
        else {
            kqcc += "Máy thắng\nNgười thắng: " + soLanNguoiThang + "\nMáy thắng: " + soLanNguoiThua;
            Toast.makeText(MainActivity.this, kqcc, Toast.LENGTH_LONG).show();
        }
    }

    public void ChiaBai() {
        int[] layLaBai = layLaBai();
        int[] baimay = new int[3];
        int indexBaiMay = 0, indexBaiNguoi = 0;
        int[] bainguoi = new int[3];
        iv1.setImageResource(mangHinhBai[layLaBai[0]]);
        iv2.setImageResource(mangHinhBai[layLaBai[1]]);
        iv3.setImageResource(mangHinhBai[layLaBai[2]]);
        iv4.setImageResource(mangHinhBai[layLaBai[3]]);
        iv5.setImageResource(mangHinhBai[layLaBai[4]]);
        iv6.setImageResource(mangHinhBai[layLaBai[5]]);
        for (int i = 0; i < layLaBai.length; i++) {
            if (i < 3) {
                baimay[indexBaiMay] =layLaBai[i];
                indexBaiMay++;
            }
            else {
                bainguoi[indexBaiNguoi] = layLaBai[i];
                indexBaiNguoi++;
            }
        }
        tv_ketquamay.setText(xuatKetQua(baimay));
        tv_ketquanguoi.setText(xuatKetQua(bainguoi));

        int kqMay = tinhKetQua(baimay);
        int kqNguoi = tinhKetQua(bainguoi);
        String kqCuoiCung = "Người " + kqNguoi + " nút và Máy " + kqMay + " nút\n";

        if (kqMay == kqNguoi) {
            kqCuoiCung += "Hòa";
            soLanNguoiHoa++;
        }
        else if (kqMay < kqNguoi) {
            kqCuoiCung += "Người chiến thắng";
            soLanNguoiThang++;
        }
        else {
            kqCuoiCung += "Máy chiên thắng";
            soLanNguoiThua++;
        }
        tv_NguoChienThang.setText(kqCuoiCung);
    }

    private String xuatKetQua(int[] arr) {
        String ketQua;
        if (tinhSoTay(arr) >= 3)
            ketQua = "Kết quả 3 tây";
        else {
            int tong = 0;
            for (int j : arr)
                if (j % 13 < 10)
                    tong += j % 13 + 1;
            if (tong % 10 == 0)
                ketQua = "Kết quả bù, số tây là " + tinhSoTay(arr);
            else
                ketQua = "Kết quả là " + (tong % 10) + " nút, số tây là " + tinhSoTay(arr);
        }
        return ketQua;
    }

    private int tinhKetQua(int[] arr) {
        int tong = 0;
        for (int j : arr)
            if (j % 13 < 10)
                tong += j % 13 + 1;
        return tong % 10;
    }

    private int tinhSoTay(int[] arr) {
        int k = 0;
        for (int j : arr)
            if (j % 13 >= 10)
                k++;
        return k;
    }

    private int[] layLaBai() {
        int[] arr = new int[6];
        int i = 0;
        arr[i++] = random();
        do {
            int k = random();
            if (!kiemTraTrung(k, arr))
                arr[i++] = k;
        } while (i < 6);
        return arr;
    }

    private int random() {
        return (int) (Math.random() * ((51) + 1));
    }

    private boolean kiemTraTrung(int k, int[] arr) {
        for (int j : arr)
            if (j == k)
                return true;
        return false;
    }

}