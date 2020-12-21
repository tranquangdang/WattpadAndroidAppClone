package com.example.wattpadclone.Home.Adapters.Beans;

import com.example.wattpadclone.Chung.Bean.Book;

import java.util.ArrayList;

public class VerticalRecyclerViewHomeBean {
    String title1, content1, title2,content2;
    ArrayList<Book> arrayList;

    public VerticalRecyclerViewHomeBean(String title1, String content1, String title2, String content2, ArrayList<Book> arrayList) {
        this.title1 = title1;
        this.content1 = content1;
        this.title2 = title2;
        this.content2 = content2;
        this.arrayList = arrayList;
    }

    public VerticalRecyclerViewHomeBean(ArrayList<Book> arrayList) {
        this.arrayList = arrayList;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public ArrayList<Book> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Book> arrayList) {
        this.arrayList = arrayList;
    }
}
