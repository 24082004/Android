package com.example.assignment_ph36082;

import java.io.Serializable;

public class NhanVien implements Serializable {
    String manv, tennv, pbnv;

    public NhanVien(String manv, String tennv, String pbnv) {
        this.manv = manv;
        this.tennv = tennv;
        this.pbnv = pbnv;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getPbnv() {
        return pbnv;
    }

    public void setPbnv(String pbnv) {
        this.pbnv = pbnv;
    }
}
