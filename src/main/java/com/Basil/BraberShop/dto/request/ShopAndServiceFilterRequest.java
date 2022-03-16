package com.Basil.BraberShop.dto.request;

import java.io.Serializable;

public class ShopAndServiceFilterRequest implements Serializable {

    ShopFilterRequest shopFilterRequest;

   ServicesFilterRequest servicesFilterRequest;

    public ServicesFilterRequest getServicesFilterRequest() {
        return servicesFilterRequest;
    }

    public void setServicesFilterRequest(ServicesFilterRequest servicesFilterRequest) {
        this.servicesFilterRequest = servicesFilterRequest;
    }


    public ShopFilterRequest getShopFilterRequest() {
        return shopFilterRequest;
    }

    public void setShopFilterRequest(ShopFilterRequest shopFilterRequest) {
        this.shopFilterRequest = shopFilterRequest;
    }
    public boolean shop_filter_request_is_set(){
        return  shopFilterRequest !=null;
    }
    public boolean service_filter_request_is_set(){
        return  servicesFilterRequest !=null;
    }
}
