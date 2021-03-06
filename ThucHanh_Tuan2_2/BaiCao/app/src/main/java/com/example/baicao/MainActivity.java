package com.example.baicao;

import androidx.appcompat.app.AlertDialog;
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
        listDoiThu.add("Ng?????i Ch??i");
        listDoiThu.add("M??y Ch??i");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listDoiThu);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spn_DoiThu.setAdapter(adapter);

        spn_DoiThu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, spn_DoiThu.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                if (i == 0)
                    et_NhapThoiGian.setEnabled(false);
                else
                    et_NhapThoiGian.setEnabled(true);
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
                }
            } else {
                int thoiGian = 1000;
                if (!Pattern.matches("[0-9]{0,5}]", et_NhapThoiGian.getText().toString())) {
                    thoiGian = Integer.parseInt(et_NhapThoiGian.getText().toString());
                    thoiGian *= 1000 + 1;
                    new CountDownTimer(thoiGian, 1000) {
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
                else {
                    Toast.makeText(MainActivity.this, "Y??u c???u nh???p l???i", Toast.LENGTH_SHORT).show();
                    et_NhapThoiGian.requestFocus();
                }
            }
        });

    }

    private void ketQuaChungCuoc() {
        String kqcc = "";
        if (soLanNguoiThang == soLanNguoiThua)
            kqcc += "H??a\nNg?????i th???ng: " + soLanNguoiThang + "\nM??y th???ng: " + soLanNguoiThua + "\nH??a: " + soLanNguoiHoa;
        else if (soLanNguoiThang > soLanNguoiThua)
            kqcc += "Ng?????i ch??i th???ng\nNg?????i th???ng: " + soLanNguoiThang + "\nM??y th???ng: " + soLanNguoiThua + "\nH??a: " + soLanNguoiHoa;
        else
            kqcc += "M??y th???ng\nNg?????i th???ng: " + soLanNguoiThang + "\nM??y th???ng: " + soLanNguoiThua + "\nH??a: " + soLanNguoiHoa;
        thongBaoKetQua("K???t qu??? chung cu???c", kqcc);
        soLanNguoiThua = soLanNguoiThang = soLanNguoiHoa = 0;
    }

    public void thongBaoKetQua(String title, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title).setMessage(content);
        AlertDialog dialog = builder.create();
        dialog.show();
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
        String kqCuoiCung = "Ng?????i " + kqNguoi + " n??t v?? M??y " + kqMay + " n??t\n";

        if (kqMay == kqNguoi) {
            kqCuoiCung += "H??a";
            soLanNguoiHoa++;
        }
        else if (kqMay < kqNguoi) {
            kqCuoiCung += "Ng?????i chi???n th???ng";
            soLanNguoiThang++;
        }
        else {
            kqCuoiCung += "M??y chi??n th???ng";
            soLanNguoiThua++;
        }
        tv_NguoChienThang.setText(kqCuoiCung);
    }

    private String xuatKetQua(int[] arr) {
        String ketQua;
        if (tinhSoTay(arr) >= 3)
            ketQua = "K???t qu??? 3 t??y";
        else {
            int tong = 0;
            for (int j : arr)
                if (j % 13 < 10)
                    tong += j % 13 + 1;
            if (tong % 10 == 0)
                ketQua = "K???t qu??? b??, s??? t??y l?? " + tinhSoTay(arr);
            else
                ketQua = "K???t qu??? l?? " + (tong % 10) + " n??t, s??? t??y l?? " + tinhSoTay(arr);
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