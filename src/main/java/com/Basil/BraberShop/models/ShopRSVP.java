package com.Basil.BraberShop.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shop_rsvp")
public class ShopRSVP {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "rsvp_id")

    Long id;
    @OneToOne

    @JoinColumn(name = "shop_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Shop shop;

    @OneToOne
    @JoinColumn(name = "service_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    ShopServices shopServices;
    @OneToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;


    @Column(name = "date")
    Date rsvpDate;

    public ShopRSVP() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ShopServices getShopServices() {
        return shopServices;
    }

    public void setShopServices(ShopServices shopServices) {
        this.shopServices = shopServices;
    }

    public Date getRsvpDate() {
        return rsvpDate;
    }

    public void setRsvpDate(Date rsvpDate) {
        this.rsvpDate = rsvpDate;
    }
}

