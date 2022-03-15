package com.Basil.BraberShop.enums;

public enum UserPermission {
    VISITOR_READ("user:read"),
    VISITOR_WRITE("user:write"),
    SHOP_READ("shop_read"),
    SHOP_WRITE("shop_write");



    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public  String getPermission(){
        return permission;
    }
}
