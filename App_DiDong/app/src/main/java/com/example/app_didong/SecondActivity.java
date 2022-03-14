package com.example.app_didong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    int index;
    ImageView iv_SanPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        iv_SanPham = findViewById(R.id.imageView_SanPham);
        int hinh = getIntent().getExtras().getInt("hinh");
        iv_SanPham.setImageResource(hinh);

        TextView tv_ThongTin = findViewById(R.id.textView_ThongTin);
        ImageButton iv_Bac = findViewById(R.id.imageButton_Bac);
        ImageButton iv_Do = findViewById(R.id.imageButton_Do);
        ImageButton iv_Den = findViewById(R.id.imageButton_Den);
        ImageButton iv_Xanh = findViewById(R.id.imageButton_Xanh);
        Button btn_Xong = findViewById(R.id.button_Xong);
        index = R.drawable.vs_blue;

        iv_Bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_SanPham.setImageResource(R.drawable.vs_bac);
                index = R.drawable.vs_bac;
                String bac = "Bac";
            }
        });

        iv_Do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_SanPham.setImageResource(R.drawable.vs_red);
                index = R.drawable.vs_red;
            }
        });

        iv_Den.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_SanPham.setImageResource(R.drawable.vs_black);
                index = R.drawable.vs_black;
            }
        });

        iv_Xanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_SanPham.setImageResource(R.drawable.vs_blue);
                index = R.drawable.vs_blue;
            }
        });

        btn_Xong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("index", index);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}