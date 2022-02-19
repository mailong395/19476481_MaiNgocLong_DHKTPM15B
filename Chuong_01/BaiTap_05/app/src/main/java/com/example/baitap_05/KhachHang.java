package com.example.baitap_05;

import java.util.Objects;

public class KhachHang {
    private String iDKH;
    private String hoTenKH;
    private int soLuongSach;
    private boolean vip;

    KhachHang() {}
    KhachHang(String idKH, String hoTenKH, int soLuongSach, boolean vip) {
        this.iDKH = iDKH;
        this.hoTenKH = hoTenKH;
        this.soLuongSach = soLuongSach;
        this.vip = vip;
    }

    public void IDKH(String idKH) {
        this.iDKH = idKH;
    }
    public String getiDKH() {
        return iDKH;
    }
    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }
    public String getHOtenKH() {
        return hoTenKH;
    }
    public void setSoLuongSach(int soLuongSach) {
        this.soLuongSach = soLuongSach;
    }
    public int getSoLuongSach() {
        return soLuongSach;
    }
    public void setVip(boolean vip) {
        this.vip = vip;
    }
    public boolean isVip() {
        return vip;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "iDKH='" + iDKH + '\'' +
                ", hoTenKH='" + hoTenKH + '\'' +
                ", soLuongSach=" + soLuongSach +
                ", vip=" + vip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KhachHang khachHang = (KhachHang) o;
        return Objects.equals(iDKH, khachHang.iDKH);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iDKH);
    }
}
