package com.Basil.BraberShop.services;

import com.Basil.BraberShop.dto.request.AddShopServiceRequest;
import com.Basil.BraberShop.dto.request.ServicesFilterRequest;
import com.Basil.BraberShop.dto.request.ShopAndServiceFilterRequest;
import com.Basil.BraberShop.models.Shop;
import com.Basil.BraberShop.models.ShopServices;

import java.util.List;

public interface ServicesShopService  {

    void AddServiceToShop(AddShopServiceRequest shopServiceRequest) throws ClassNotFoundException;
    void DeleteById(Long id, Long Shop_id );
    ShopServices getServiceById(Long id);
    void updateService(ShopServices shopServices);
    List<ShopServices>  ServiceFilter(ServicesFilterRequest  servicesFilterRequest);

     List<Shop> ShopAndServiceFilter(ShopAndServiceFilterRequest shopAndServiceFilterRequest);




}
