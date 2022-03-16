package com.Basil.BraberShop.dto.request;

import java.io.Serializable;

public class ShopFilterRequest implements Serializable {

    String name ;
    String city;
    Double rate;

    public ShopFilterRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}