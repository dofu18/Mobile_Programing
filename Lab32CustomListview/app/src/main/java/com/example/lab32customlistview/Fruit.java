package com.example.lab32customlistview;

public class Fruit {
    private String Ten;
    private String Mota;
    private String Image;
    public Fruit(String ten, String mota, String image) {
        Ten = ten;
        Mota = mota;
        Image = image;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
