package com.example.lab5b;

public class Module {
    private String ten;
    private String mota;
    private String hinhAnh;
    private String icon;

    public Module(String ten, String mota, String hinhAnh, String icon) {
        this.ten = ten;
        this.mota = mota;
        this.hinhAnh = hinhAnh;
        this.icon = icon;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
