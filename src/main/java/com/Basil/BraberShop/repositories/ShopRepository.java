package com.Basil.BraberShop.repositories;

import com.Basil.BraberShop.models.Shop;
import com.Basil.BraberShop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop,Long> {

    List<Shop> findByShopNameAndRateAndCity(String names, Double Rates, String locations);
    List<Shop> findByShopNameAndCity(String names, String locations);
    List<Shop> findByShopNameAndRate(String names, Double rates);
    List<Shop> findByRateAndCity(Double rates, String location);
    List<Shop> findByShopName(String name);
    List<Shop> findByRateGreaterThan(Double rate);
    List<Shop> findByCity(String location);
    Shop findByOwner(User user);





}
