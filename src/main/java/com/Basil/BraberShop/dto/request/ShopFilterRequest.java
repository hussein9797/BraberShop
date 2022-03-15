package com.Basil.BraberShop.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShopFilterRequest implements Serializable {

    List<String> name =new ArrayList<>();
    List<String> city = new ArrayList<>();
    List<String> rate=new ArrayList<>();

    public ShopFilterRequest() {
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getCity() {
        return city;
    }

    public void setCity(List<String> city) {
        this.city = city;
    }

    public List<String> getRate() {
        return rate;
    }

    public void setRate(List<String> rate) {
        this.rate = rate;
    }
}