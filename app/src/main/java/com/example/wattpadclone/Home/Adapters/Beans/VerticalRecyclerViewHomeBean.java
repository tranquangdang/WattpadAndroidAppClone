package com.example.wattpadclone.Home.Adapters.Beans;

import java.util.ArrayList;

public class VerticalRecyclerViewHomeBean {
    String title1, content1, title2,content2;
    ArrayList<HorizontalViewPagerHomeBean1> arrayList1;
    ArrayList<HorizontalRecyclerViewHomeBean2> arrayList2;

    public VerticalRecyclerViewHomeBean(String title1, String content1, String title2, String content2, ArrayList<HorizontalViewPagerHomeBean1> arrayList1, ArrayList<HorizontalRecyclerViewHomeBean2> arrayList2) {
        this.title1 = title1;
        this.content1 = content1;
        this.title2 = title2;
        this.content2 = content2;
        this.arrayList1 = arrayList1;
        this.arrayList2 = arrayList2;
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

    public ArrayList<HorizontalViewPagerHomeBean1> getArrayList1() {
        return arrayList1;
    }

    public void setArrayList1(ArrayList<HorizontalViewPagerHomeBean1> arrayList1) {
        this.arrayList1 = arrayList1;
    }

    public ArrayList<HorizontalRecyclerViewHomeBean2> getArrayList2() {
        return arrayList2;
    }

    public void setArrayList2(ArrayList<HorizontalRecyclerViewHomeBean2> arrayList2) {
        this.arrayList2 = arrayList2;
    }
}
