package com.Basil.BraberShop.repositories;

import com.Basil.BraberShop.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop,Long> {

    List<Shop> findByShopNameInAndRateInAndCityIn(List<String> names,List<String> Rates,List<String> locations);
    List<Shop> findByShopNameInAndCityIn(List<String> names,List<String> locations);
    List<Shop> findByShopNameInAndRateIn(List<String> names,List<String> rates);
    List<Shop> findByRateInAndCityIn(List<String> rates,List<String> location);
    List<Shop> findByShopNameIn(List<String> name);
    List<Shop> findByRateIn(List<String> rate);
    List<Shop> findByCityIn(List<String> location);





}
