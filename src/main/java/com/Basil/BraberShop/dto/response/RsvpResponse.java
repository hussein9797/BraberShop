package com.Basil.BraberShop.dto.response;

import java.util.Date;

public class RsvpResponse {
    private String userName;
    private String serviceName;
    private Double cost;
    private Double duration;
    private String shopName;
    private String service_type;
    private Date date;
    private String city;
    private Double rate;
 private Location location;
    public RsvpResponse(String userName, String serviceName, Double cost, Double duration, String shopName, String service_type, Date date, String city,Location location, Double rate) {
       this.userName=userName;
        this.serviceName = serviceName;
        this.cost = cost;
        this.duration = duration;
        this.shopName = shopName;
        this.service_type = service_type;
        this.date = date;
        this.city = city;
        this.rate=rate;
        this.location=location;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getDuration() {
        return duration;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
