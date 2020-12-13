package com.example.wattpadclone.Library.Adapter;

public class watpad  {
    int anh;
    String title,name;
    public watpad(int anh, String title, String name) {
        this.anh = anh;
        this.title = title;
        this.name = name;
    }
    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTittle() {
        return title;
    }

    public void setTittle(String tittle) {
        this.title = tittle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
