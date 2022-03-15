package com.Basil.BraberShop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")

public class ShopServices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "service_id")
    Long id;
    @Column(name = "service_name")
    String serviceName;
    @Column(name = "cost")
    Double cost;
    @Column(name = "duration")
    Double duration;
    @Column(name = "service_type")
    String service_type;


    @ManyToMany(mappedBy = "shopServicesList")
    @JsonIgnore
    List<Shop> shopList;


    @ManyToOne
    @JoinColumn(name = "sub_service_id")
    @OnDelete(action = OnDeleteAction.CASCADE)

    ShopSubService shopSubService;

    public ShopServices() {
    }


    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String service_name) {
        this.serviceName = service_name;
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

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public ShopSubService getShopSubService() {
        return shopSubService;
    }

    public void setShopSubService(ShopSubService shopSubService) {
        this.shopSubService = shopSubService;
    }
}
