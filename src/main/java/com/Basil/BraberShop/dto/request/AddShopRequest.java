package com.Basil.BraberShop.dto.request;

import java.io.Serializable;

public class AddShopRequest implements Serializable {

    String shop_name;
    String city;
    Double rate;
    Double lat;
    Double lng;


    public AddShopRequest() {
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

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

    public String getShop_name() {
        return shop_name;
    }

    public String getCity() {
        return city;
    }

    public Double getRate() {
        return rate;
    }
}
