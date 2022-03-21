package com.example.app_didong;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv_HinhSanPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_ChonMau = findViewById(R.id.button_ChonMau);

        iv_HinhSanPham = findViewById(R.id.imageView_HinhSanPham);
        iv_HinhSanPham.setImageResource(R.drawable.vs_blue);
        iv_HinhSanPham.setTag(R.drawable.vs_blue);

        btn_ChonMau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                int hinh = (int) iv_HinhSanPham.getTag();
                intent.putExtra("hinh", hinh);
                startActivityForResult(intent, 999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK) {
            int index = data.getIntExtra("index", R.drawable.vs_blue);
            iv_HinhSanPham.setImageResource(index);
            iv_HinhSanPham.setTag(index);
        }
    }
}