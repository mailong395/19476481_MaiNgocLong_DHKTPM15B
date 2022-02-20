package com.example.baitap_05;

public class NhanVienThoiVu extends NhanVien {
    @Override
    public double tinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + " --> Part time = " + tinhLuong();
    }
}
