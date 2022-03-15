package com.Basil.BraberShop.models;

import javax.persistence.*;

@Entity
@Table(name = "sub_service")
public class ShopSubService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "sub_service_id")
    Long id;
    @Column(name = "sub_service_name")
    String subService_name;
    @Column(name = "cost")
    Double cost;
    @Column(name = "duration")
    Long duration;


    public ShopSubService() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubService_name() {
        return subService_name;
    }

    public void setSubService_name(String subService_name) {
        this.subService_name = subService_name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
