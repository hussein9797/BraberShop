package com.Basil.BraberShop.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BookingRequest implements Serializable {
    Long shop_id;
    Long services_id;
    String user_name;
    Date rsvp_date;

    public Date getRsvp_date() {
        return rsvp_date;
    }

    public void setRsvp_date(Date rsvp_date) {
        this.rsvp_date = rsvp_date;
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public Long getServices_id() {
        return services_id;
    }

    public void setServices_id(Long services_id) {
        this.services_id = services_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
