package com.Basil.BraberShop.repositories;

import com.Basil.BraberShop.models.Shop;
import com.Basil.BraberShop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop,Long> {

    List<Shop> findByShopNameContainingAndRateLessThanAndCity(String names, Double Rates, String locations);
    List<Shop> findByShopNameContainingAndCity(String names, String locations);
    List<Shop> findByShopNameContainingAndRateLessThan(String names, Double rates);
    List<Shop> findByRateLessThanAndCity(Double rates, String location);
    List<Shop> findByShopNameContaining(String name);
    List<Shop> findByRateLessThan(Double rate);
    List<Shop> findByCity(String location);
    Shop findByOwner(User user);





}
