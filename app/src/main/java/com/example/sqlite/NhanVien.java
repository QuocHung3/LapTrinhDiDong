package com.example.sqlite;

public class NhanVien {
    private int maNV;
    private String tenNV,soDT,diaChi;

    public NhanVien(int maNV, String tenNV, String soDT, String diaChi) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soDT = soDT;
        this.diaChi = diaChi;
    }

    public NhanVien() {
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return tenNV + " - " + soDT;
    }
}
