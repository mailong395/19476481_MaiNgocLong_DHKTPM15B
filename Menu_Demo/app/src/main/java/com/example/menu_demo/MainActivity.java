package com.example.menu_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    * Quản lý nhân viên bài củ
    * Thêm nút đọc và nút ghi
    * sử lý: nhập 1 số nhân viên add vào listview
    * nút ghi thêm 5 nhân viên vào bộ nhớ trong
    * đóng app và mở app nhấn nút đọc dữ liệu sẽ đỗ vòa list view
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnXemSinhVien:
                Toast.makeText(this, "Bạn đã chọn mục xem sinh viên", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnXemLopHoc:
                Toast.makeText(this, "Bạn đã chọn mục xem lớp học", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}