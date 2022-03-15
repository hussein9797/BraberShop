package com.Basil.BraberShop.dto.request;

import java.io.Serializable;

public class ServicesFilterRequest implements Serializable {
    String service_name;
    Double cost;

    public ServicesFilterRequest() {
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
}
