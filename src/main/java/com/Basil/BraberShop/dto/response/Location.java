package com.Basil.BraberShop.dto.response;

import java.io.Serializable;

public class Location implements Serializable {
    Double lat;

    Double lng;




    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
