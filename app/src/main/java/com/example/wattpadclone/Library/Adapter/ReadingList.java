package com.example.wattpadclone.Library.Adapter;

public class ReadingList {
    int anh1,anh2,anh3;
    String title,stories;
    public ReadingList(int anh1, int anh2, int anh3, String title, String stories) {
        this.anh1 = anh1;
        this.anh2 = anh2;
        this.anh3 = anh3;
        this.title = title;
        this.stories = stories;
    }
    public int getAnh1() {
        return anh1;
    }

    public void setAnh1(int anh1) {
        this.anh1 = anh1;
    }

    public int getAnh2() {
        return anh2;
    }

    public void setAnh2(int anh2) {
        this.anh2 = anh2;
    }

    public int getAnh3() {
        return anh3;
    }

    public void setAnh3(int anh3) {
        this.anh3 = anh3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStories() {
        return stories;
    }

    public void setStories(String stories) {
        this.stories = stories;
    }
}
