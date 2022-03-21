package com.example.uidemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<NhanVien> nv_List = new ArrayList<NhanVien>();
    MyArrayAdapter myArrayAdapter = null;
    String[] dv_List;
    String donvi;
    ImageView iv_Avatar;
    int SELECT_IMAGE_CODE = 1;
    Uri uri = null;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_Avatar = findViewById(R.id.imageView_Avatar);
        Button bt_ChonHinh = findViewById(R.id.button_ChonHinh);

        EditText et_MaSo = findViewById(R.id.editText_NhapMa);
        EditText et_HoVaTen = findViewById(R.id.editText_NhapHoVaTen);
        RadioGroup rg_GioiTinh = findViewById(R.id.radioGroup_GioiTinh);

        pref = getApplicationContext().getSharedPreferences("myfile", 0);
        editor = pref.edit();

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
                    myArrayAdapter.notifyDataSetChanged();
                }
            }
        });

        Button btn_Xoa = findViewById(R.id.button_Xoa);
        btn_Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = lv_NhanVien.getChildCount() - 1; i >= 0; i--) {
                    View v = lv_NhanVien.getChildAt(i);
                    CheckBox chk = v.findViewById(R.id.checkBox_Item);
                    if (chk.isChecked()) {
                        nv_List.remove(i);
                    }
                    myArrayAdapter.notifyDataSetChanged();
                }
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

        Button btn_Doc = findViewById(R.id.button_Doc);
        btn_Doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                int ma = pref.getInt("nv_ma0", -1   );
                if (ma != -1 ) {
                    String tep = "";
                    for (int i = 0; pref.getInt("nv_ma" + i, -1   ) != -1; i++) {
                        ma = pref.getInt("nv_ma" + i, -1   );
                        String ten = pref.getString("nv_ten" + i, null);
                        String gioitinh = pref.getString("nv_gioitinh" + i, null);
                        String donvi = pref.getString("nv_donvi" + i, null);

                        String imageUriString = pref.getString("nv_uri" + i, null);
                        uri = Uri.parse(imageUriString);

                        tep += uri.toString() + "\n";
                        NhanVien nv_tam = new NhanVien(ma, ten, gioitinh, donvi, uri);
                        nv_List.add(nv_tam);
                        myArrayAdapter.notifyDataSetChanged();
                    }
                    Toast.makeText(MainActivity.this, tep, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Hệ thống chưa có dữ liệu", Toast.LENGTH_LONG).show();
                }
                startActivityForResult(Intent.createChooser(intent, "Title"), SELECT_IMAGE_CODE);
            }
        });

        Button btn_Ghi = findViewById(R.id.button_Ghi);
        btn_Ghi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < nv_List.size(); i++) {
                    int ma = nv_List.get(i).getMaso();
                    String ten = nv_List.get(i).getHoten();
                    String gioiTinnh = nv_List.get(i).getGioitinh();
                    String donVi = nv_List.get(i).getDonvi();
                    String link_uri = nv_List.get(i).getUri().toString();

                    editor.putInt("nv_ma" + i, ma);
                    editor.putString("nv_ten" + i, ten);
                    editor.putString("nv_gioitinh" + i, gioiTinnh);
                    editor.putString("nv_donvi" + i, donVi);
                    editor.putString("nv_uri" + i, link_uri);
                    editor.commit();
                }
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