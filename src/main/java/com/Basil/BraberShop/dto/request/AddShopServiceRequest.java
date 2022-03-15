package com.Basil.BraberShop.dto.request;

import java.io.Serializable;

public class AddShopServiceRequest implements Serializable {

    Long shop_id;
    String service_name;
    Double cost;
    Double service_duration;
    String service_type;


    public AddShopServiceRequest() {
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getService_duration() {
        return service_duration;
    }

    public void setService_duration(Double service_duration) {
        this.service_duration = service_duration;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }
}
