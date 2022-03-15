package com.Basil.BraberShop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "shop_id")
    Long id;

    @Column(name="shop_name")
    String shopName;

    @Column(name = "city")
    String city;
    @Column(name = "lat")
    Double lat;
    @Column(name = "lng")
    Double lng;


    @Column(name = "rate")
    Double rate;



    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    User owner;



    @ManyToMany
    @JoinTable(name = "shops_services",
            joinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id", referencedColumnName = "service_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<ShopServices> shopServicesList;

    public Shop() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String location) {
        this.city = location;
    }

    public Double getRate() {
        return rate;
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

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public List<ShopServices> getShopServicesList() {
        return shopServicesList;
    }
    public void RemoveService(ShopServices shopServices){
        this.getShopServicesList().remove(shopServices);
        shopServices.getShopList().remove(this);

    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public void setShopServicesList(List<ShopServices> shopServicesList) {
        this.shopServicesList = shopServicesList;
    }

}
