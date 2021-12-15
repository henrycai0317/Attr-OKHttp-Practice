package com.example.viewwithattrpractice;

public class PavilionArea {
    private String e_pic_url;
    private String e_geo;
    private String e_Info;
    private String e_no;
    private String e_category;
    private String e_name;
    private String e_memo;
    private String id;
    private String e_url;

    public PavilionArea(String e_pic_url, String e_geo, String e_Info, String e_no, String e_category, String e_name, String e_memo, String id, String e_url) {
        this.e_pic_url = e_pic_url;
        this.e_geo = e_geo;
        this.e_Info = e_Info;
        this.e_no = e_no;
        this.e_category = e_category;
        this.e_name = e_name;
        this.e_memo = e_memo;
        this.id = id;
        this.e_url = e_url;
    }

    public String getE_pic_url() {
        return e_pic_url;
    }

    public void setE_pic_url(String e_pic_url) {
        this.e_pic_url = e_pic_url;
    }

    public String getE_geo() {
        return e_geo;
    }

    public void setE_geo(String e_geo) {
        this.e_geo = e_geo;
    }

    public String getE_Info() {
        return e_Info;
    }

    public void setE_Info(String e_Info) {
        this.e_Info = e_Info;
    }

    public String getE_no() {
        return e_no;
    }

    public void setE_no(String e_no) {
        this.e_no = e_no;
    }

    public String getE_category() {
        return e_category;
    }

    public void setE_category(String e_category) {
        this.e_category = e_category;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_memo() {
        return e_memo;
    }

    public void setE_memo(String e_memo) {
        this.e_memo = e_memo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getE_url() {
        return e_url;
    }

    public void setE_url(String e_url) {
        this.e_url = e_url;
    }
}
