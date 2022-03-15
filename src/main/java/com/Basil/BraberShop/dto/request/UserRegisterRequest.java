package com.Basil.BraberShop.dto.request;

import java.io.Serializable;

public class UserRegisterRequest implements Serializable {
    private String user_name;
    private String password;

    public UserRegisterRequest() {
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
}
