package com.example.ltdd_listview;

public class TacGia {
    private String tenTG;
    private String motaTG;
    private int imgTG;


    public TacGia(String tenTG, String motaTG, int imgTG) {
        this.tenTG = tenTG;
        this.motaTG = motaTG;
        this.imgTG = imgTG;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getMotaTG() {
        return motaTG;
    }

    public void setMotaTG(String motaTG) {
        this.motaTG = motaTG;
    }

    public int getImgTG() {
        return imgTG;
    }

    public void setImgTG(int imgTG) {
        this.imgTG = imgTG;
    }
}
