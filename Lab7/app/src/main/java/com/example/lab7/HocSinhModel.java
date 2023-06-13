package com.example.lab7;

import java.io.Serializable;

public class HocSinhModel implements Serializable {
        private String name;
        private  String idSV;
        private int Diem;

        public HocSinhModel(String name, String idSV, int diem) {
                this.name = name;
                this.idSV = idSV;
                Diem = diem;
        }

        public HocSinhModel() {
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getIdSV() {
                return idSV;
        }

        public void setIdSV(String idSV) {
                this.idSV = idSV;
        }

        public int getDiem() {
                return Diem;
        }

        public void setDiem(int diem) {
                Diem = diem;
        }
}

