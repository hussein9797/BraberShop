package com.Basil.BraberShop.dto.request;

import java.io.Serializable;

public class ShopRegisterRequest implements Serializable {
    private String user_name;
    private String password;
    private String shop_name;

    public ShopRegisterRequest() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }
}
