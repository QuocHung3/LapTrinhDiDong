package com.example.sqlite_qlsach;

public class Sach {
    private String maTG,tenTG,tenSach,ngayXB;

    public Sach(String maTG, String tenTG, String tenSach, String ngayXB) {
        this.maTG = maTG;
        this.tenTG = tenTG;
        this.tenSach = tenSach;
        this.ngayXB = ngayXB;
    }

    public Sach() {
    }

    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNgayXB() {
        return ngayXB;
    }

    public void setNgayXB(String ngayXB) {
        this.ngayXB = ngayXB;
    }

    @Override
    public String toString() {
        return maTG + " " + tenTG + " " + tenSach + " " + ngayXB;
    }
}
