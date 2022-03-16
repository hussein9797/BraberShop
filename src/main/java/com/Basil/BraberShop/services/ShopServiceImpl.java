package com.Basil.BraberShop.services;


import com.Basil.BraberShop.Excptions.NotFoundException;
import com.Basil.BraberShop.dto.request.AddShopRequest;
import com.Basil.BraberShop.dto.request.ShopFilterRequest;
import com.Basil.BraberShop.models.Shop;
import com.Basil.BraberShop.models.User;
import com.Basil.BraberShop.repositories.ShopRepository;
import com.Basil.BraberShop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopRepository shopRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public void updateShop(AddShopRequest addShopRequest) {
        try {

            Shop shop =this.getShopByUserName(addShopRequest.getUsername());
         //   Shop newShop = new Shop();
            shop.setShopName(addShopRequest.getShop_name());
            shop.setRate(addShopRequest.getRate());
            shop.setCity(addShopRequest.getCity());
            shop.setLat(addShopRequest.getLat());
            shop.setLng(addShopRequest.getLng());
            shopRepository.save(shop);
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
    public List<List<Shop>> getAllShop() {
        return Collections.singletonList(shopRepository.findAll());
    }

    @Override
    public List<Shop> getShopsByFilter(ShopFilterRequest shopFilterRequest) {


        try {
            if (!shopFilterRequest.getName().isEmpty() && shopFilterRequest.getCity()!=null && shopFilterRequest.getRate()!=null){
            List<Shop> shops=shopRepository.findByShopNameAndRateLessThanAndCity(shopFilterRequest.getName(),shopFilterRequest.getRate(),shopFilterRequest.getCity());
            return  shops;}
            if (!shopFilterRequest.getName().isEmpty() && shopFilterRequest.getCity()!=null){
                List<Shop> shops=shopRepository.findByShopNameAndCity(shopFilterRequest.getName(),shopFilterRequest.getCity());
              return shops;
            }
            if (!shopFilterRequest.getName().isEmpty() && shopFilterRequest.getRate()!=null){
                List<Shop> shops=shopRepository.findByShopNameAndRateLessThan(shopFilterRequest.getName(),shopFilterRequest.getRate());
              return shops;
            }
            if ( shopFilterRequest.getCity()!=null && shopFilterRequest.getRate()!=null){
                List<Shop> shops=shopRepository.findByRateLessThanAndCity(shopFilterRequest.getRate(),shopFilterRequest.getCity());
                return  shops;}
           if (shopFilterRequest.getRate()==null && shopFilterRequest.getCity()==null){
               List<Shop> shops=shopRepository.findByShopName(shopFilterRequest.getName());
               return shops;

           }
           if (shopFilterRequest.getName()==null && shopFilterRequest.getCity()==null){
               List<Shop> shops=shopRepository.findByRateLessThan(shopFilterRequest.getRate());
               return shops;

           }
           if (shopFilterRequest.getName().isEmpty() && shopFilterRequest.getRate()!=null){
               List<Shop> shops=shopRepository.findByCity(shopFilterRequest.getCity());
               return shops;

           }
           else
               return  new ArrayList<>();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }



    }

    @Override
    public Shop getShopByUserName(String username) {
        User user = userRepository.findByUsername(username);
        Shop shop=shopRepository.findByOwner(user);
        return shop;

    }
}
