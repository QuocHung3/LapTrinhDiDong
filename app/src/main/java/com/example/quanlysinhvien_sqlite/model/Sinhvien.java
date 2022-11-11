package com.example.quanlysinhvien_sqlite.model;

import java.io.Serializable;

public class Sinhvien implements Serializable {
    private String Tensv,Namsinh,lop;
    private int Diemtoan,Diemtin,DiemTA;

    public Sinhvien(String tensv, String namsinh, String lop, int diemtoan, int diemtin, int diemTA) {
        Tensv = tensv;
        Namsinh = namsinh;
        this.lop = lop;
        Diemtoan = diemtoan;
        Diemtin = diemtin;
        DiemTA = diemTA;
    }

    public Sinhvien() {

    }

    public String getTensv() {
        return Tensv;
    }

    public void setTensv(String tensv) {
        Tensv = tensv;
    }

    public String getNamsinh() {
        return Namsinh;
    }

    public void setNamsinh(String namsinh) {
        Namsinh = namsinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getDiemtoan() {
        return Diemtoan;
    }

    public void setDiemtoan(int diemtoan) {
        Diemtoan = diemtoan;
    }

    public int getDiemtin() {
        return Diemtin;
    }

    public void setDiemtin(int diemtin) {
        Diemtin = diemtin;
    }

    public int getDiemTA() {
        return DiemTA;
    }

    public void setDiemTA(int diemTA) {
        DiemTA = diemTA;
    }
    public int dtb(){
        return (Diemtoan + Diemtin +DiemTA) /3;

    }
}
