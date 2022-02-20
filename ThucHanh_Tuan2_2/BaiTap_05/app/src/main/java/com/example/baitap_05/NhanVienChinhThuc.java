package com.example.baitap_05;

public class NhanVienChinhThuc extends NhanVien {

    @Override
    public double tinhLuong() {
        return 500;
    }

    @Override
    public String toString() {
        return super.toString() + " --> Full time = " + tinhLuong();
    }
}
