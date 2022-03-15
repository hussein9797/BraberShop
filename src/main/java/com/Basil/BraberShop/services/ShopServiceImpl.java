package com.Basil.BraberShop.services;


import com.Basil.BraberShop.Excptions.NotFoundException;
import com.Basil.BraberShop.dto.request.AddShopRequest;
import com.Basil.BraberShop.dto.request.ShopFilterRequest;
import com.Basil.BraberShop.models.Shop;
import com.Basil.BraberShop.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopRepository shopRepository;


    @Override
    public void addShop(AddShopRequest addShopRequest) {
        try {
            Shop newShop = new Shop();
            newShop.setShopName(addShopRequest.getShop_name());
            newShop.setRate(addShopRequest.getRate());
            newShop.setCity(addShopRequest.getCity());
            newShop.setLat(addShopRequest.getLat());
            newShop.setLng(addShopRequest.getLng());
            shopRepository.save(newShop);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Shop getShopById(Long id)  {
        try {


            Optional<Shop> shop = shopRepository.findById(id);
            if (shop.isPresent()) {
                return shop.get();

            } else
                throw new NotFoundException("shop dose not exist ");

        }catch (Exception e){
            throw  e;

        }
    }

    @Override
    public List<Shop> getAllShop() {
        return shopRepository.findAll();
    }

    @Override
    public List<Shop> getShopsByFilter(ShopFilterRequest shopFilterRequest) {


        try {
            if (!shopFilterRequest.getName().isEmpty() && !shopFilterRequest.getCity().isEmpty() && !shopFilterRequest.getRate().isEmpty()){
            List<Shop> shops=shopRepository.findByShopNameInAndRateInAndCityIn(shopFilterRequest.getName(),shopFilterRequest.getRate(),shopFilterRequest.getCity());
            return  shops;}
            if (!shopFilterRequest.getName().isEmpty() && !shopFilterRequest.getCity().isEmpty()){
                List<Shop> shops=shopRepository.findByShopNameInAndCityIn(shopFilterRequest.getName(),shopFilterRequest.getCity());
              return shops;
            }
            if (!shopFilterRequest.getName().isEmpty() && !shopFilterRequest.getRate().isEmpty()){
                List<Shop> shops=shopRepository.findByShopNameInAndRateIn(shopFilterRequest.getName(),shopFilterRequest.getRate());
              return shops;
            }
            if ( !shopFilterRequest.getCity().isEmpty() && !shopFilterRequest.getRate().isEmpty()){
                List<Shop> shops=shopRepository.findByRateInAndCityIn(shopFilterRequest.getRate(),shopFilterRequest.getCity());
                return  shops;}
           if (shopFilterRequest.getRate().isEmpty() && shopFilterRequest.getCity().isEmpty()){
               List<Shop> shops=shopRepository.findByShopNameIn(shopFilterRequest.getName());
               return shops;

           }
           if (shopFilterRequest.getName().isEmpty() && shopFilterRequest.getCity().isEmpty()){
               List<Shop> shops=shopRepository.findByRateIn(shopFilterRequest.getRate());
               return shops;

           }
           if (shopFilterRequest.getName().isEmpty() && shopFilterRequest.getRate().isEmpty()){
               List<Shop> shops=shopRepository.findByCityIn(shopFilterRequest.getCity());
               return shops;

           }
           else
               return  new ArrayList<>();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }



    }
}
