package com.example.bkt2_qlthuocnam;

public class Account {
    private String acc,pass;

    public Account(String acc, String pass) {
        this.acc = acc;
        this.pass = pass;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
