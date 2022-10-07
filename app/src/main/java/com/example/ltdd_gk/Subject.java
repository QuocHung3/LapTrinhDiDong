package com.example.ltdd_gk;



public class Subject {
    private String name,desc;
    private int img;

    public Subject(String name, String desc, int img) {
        this.name = name;
        this.desc = desc;
        this.img = img;
    }

    public Subject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
