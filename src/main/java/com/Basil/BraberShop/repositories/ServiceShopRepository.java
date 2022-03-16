package com.Basil.BraberShop.repositories;

import com.Basil.BraberShop.models.Shop;
import com.Basil.BraberShop.models.ShopServices;
import com.Basil.BraberShop.services.ShopService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceShopRepository extends JpaRepository<ShopServices,Long> {
    List<ShopServices> findByShopListInAndCostLessThanEqual(List<Shop> shops,Double cost);
    List<ShopServices> findByShopListInAndCostAndServiceNameContaining(List<Shop> shops,Double cost,String service_name);
    List<ShopServices> findByShopListInAndServiceNameContaining(List<Shop> shops,String service_name);
    List<ShopServices> findByCostLessThanEqual(Double cost);
    List<ShopServices> findByServiceNameContaining(String serviceName);
    List<ShopServices> findByServiceNameContainingAndCostLessThanEqual(String serviceName, Double cost);

    
}
