package com.example.quanlysinhvien_sqlite.model;

public class Lop {
    private String Malop,Tenlop;

    public Lop(String malop, String tenlop) {
        Malop = malop;
        Tenlop = tenlop;
    }

    public Lop() {

    }

    public String getMalop() {
        return Malop;
    }

    public void setMalop(String malop) {
        Malop = malop;
    }

    public String getTenlop() {
        return Tenlop;
    }

    public void setTenlop(String tenlop) {
        Tenlop = tenlop;
    }
}
