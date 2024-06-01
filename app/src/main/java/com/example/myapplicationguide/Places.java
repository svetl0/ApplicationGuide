package com.example.myapplicationguide;


import com.google.firebase.firestore.GeoPoint;

public class Places {
    private String idName, detailsdata, img;

    GeoPoint geoPoint;

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    public Places() {
        // empty constructor
        // required for Firebase.
    }




    public Places(String idName, String detailsdata, String img, GeoPoint geoPoint) {
        this.idName = idName;
        this.detailsdata = detailsdata;
        this.img = img;
        this.geoPoint = geoPoint;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIdName() {
        return idName;
    }

    public String getDetailsdata() {
        return detailsdata;
    }



    public void setIdName(String idName) {
        this.idName = idName;
    }

    public void setDetailsdata(String detailsdata) {
        this.detailsdata = detailsdata;
    }


}

