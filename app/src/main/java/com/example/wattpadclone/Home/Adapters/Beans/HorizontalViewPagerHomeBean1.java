package com.example.wattpadclone.Home.Adapters.Beans;

public class HorizontalViewPagerHomeBean1 {
    int img;
    String title, content, tag;

    public HorizontalViewPagerHomeBean1(int img, String title, String content, String tag) {
        this.img = img;
        this.title = title;
        this.content = content;
        this.tag = tag;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
