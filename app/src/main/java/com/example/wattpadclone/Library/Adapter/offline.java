package com.example.wattpadclone.Library.Adapter;

public class offline {
    int gr_anh_off;
    String gr_name_off,gr_title_off;

    public offline(int gr_anh_off, String gr_name_off, String gr_title_off) {
        this.gr_anh_off = gr_anh_off;
        this.gr_name_off = gr_name_off;
        this.gr_title_off = gr_title_off;
    }

    public int getGr_anh_off() {
        return gr_anh_off;
    }

    public void setGr_anh_off(int gr_anh_off) {
        this.gr_anh_off = gr_anh_off;
    }

    public String getGr_name_off() {
        return gr_name_off;
    }

    public void setGr_name_off(String gr_name_off) {
        this.gr_name_off = gr_name_off;
    }

    public String getGr_title_off() {
        return gr_title_off;
    }

    public void setGr_title_off(String gr_title_off) {
        this.gr_title_off = gr_title_off;
    }
}
