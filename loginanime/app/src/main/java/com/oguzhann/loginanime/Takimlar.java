package com.oguzhann.loginanime;

import android.graphics.Bitmap;

public class Takimlar {
    private String takim,takiminaciklamasi;
    private Bitmap resim;

    public Takimlar(String takim, String takiminaciklamasi, Bitmap resim) {
        this.takim = takim;
        this.takiminaciklamasi = takiminaciklamasi;
        this.resim = resim;
    }

    public String getTakim() {
        return takim;
    }

    public void setTakim(String takim) {
        this.takim = takim;
    }

    public String getTakiminaciklamasi() {
        return takiminaciklamasi;
    }

    public void setTakiminaciklamasi(String takiminaciklamasi) {
        this.takiminaciklamasi = takiminaciklamasi;
    }

    public Bitmap getResim() {
        return resim;
    }

    public void setResim(Bitmap resim) {
        this.resim = resim;
    }
}
