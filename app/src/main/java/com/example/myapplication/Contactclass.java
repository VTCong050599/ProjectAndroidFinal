package com.example.myapplication;

public class Contactclass {
    private String ten;
    private String phoneNumber;
    private int Hinh;

    public Contactclass(String ten, String phoneNumber, int hinh) {
        this.ten = ten;
        this.phoneNumber = phoneNumber;
        this.Hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
