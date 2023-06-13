package com.example.assignment_ph36082;

import java.io.Serializable;

public class PhongBan implements Serializable{
    private int anh;
    private String name;

    public PhongBan(int anh, String name) {
        this.anh = anh;
        this.name = name;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
