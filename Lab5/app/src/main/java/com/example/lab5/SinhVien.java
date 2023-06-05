package com.example.lab5;

import java.io.Serializable;

public class SinhVien implements Serializable {
    public String coSo;
    public String hoTen;
    public String diaChi;

    public SinhVien(String coSo, String hoTen, String diaChi) {
        this.coSo = coSo;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
    }
}
