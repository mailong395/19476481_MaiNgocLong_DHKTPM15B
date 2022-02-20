package com.example.baitap_05;

public abstract class NhanVien {
    private String MaNV;
    private String TenNV;

    NhanVien() {}
    NhanVien(String MaNV, String TenNV, String LoaiNV) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }
    public String getMaNV() {
        return MaNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public abstract double tinhLuong();

    @Override
    public String toString() {
        return "NhanVien{" +
                "MaNV='" + MaNV + '\'' +
                ", TenNV='" + TenNV + '\'' +
                '}';
    }
}
