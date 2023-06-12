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

    public String getCoSo() {
        return coSo;
    }

    public void setCoSo(String coSo) {
        this.coSo = coSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
