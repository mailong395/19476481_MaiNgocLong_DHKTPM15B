package com.example.uidemo;

import android.net.Uri;

public class NhanVien {
    private int maso;
    private String  hoten;
    private String gioitinh;
    private String donvi;
    private Uri uri;

    public NhanVien(int maso, String hoten, String gioitinh, String donvi, Uri uri) {
        this.maso = maso;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
        this.uri = uri;
    }

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Mã số nhân viên: " + maso + "\n" +
                "Họ và Tên: " + hoten + "\n" +
                "Giới Tính: " + gioitinh + "\n" +
                "Đơn vị: " + donvi + "\n";
    }
}
