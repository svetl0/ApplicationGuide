package com.example.myapplicationguide;

public class SliderData {


    private String imgUrl;

    // empty constructor which is
    // required when using Firebase.
    public SliderData() {
    }


    public SliderData(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}