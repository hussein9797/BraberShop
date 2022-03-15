package com.Basil.BraberShop.controllers.ShopController;

import com.Basil.BraberShop.dto.request.AddShopRequest;
import com.Basil.BraberShop.dto.request.ShopFilterRequest;
import com.Basil.BraberShop.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('shop_write')")
   // @PreAuthorize("hasAnyRole('SHOP_OWNER')")
    ResponseEntity<Object> addShop(@RequestBody AddShopRequest addShopRequest){

        try {
            shopService.addShop(addShopRequest);
            return new ResponseEntity<>("shop added successfully ", HttpStatus.OK);


        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }



    }
    @PostMapping("/getAll")
    @PreAuthorize("hasAuthority('shop_read')")
    ResponseEntity<Object> getAllShops(){

        try {

            return new ResponseEntity<>(shopService.getAllShop(), HttpStatus.OK);


        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }



    }
    @PostMapping("/shop_filter")
    @PreAuthorize("hasAuthority('shop_read')")
    ResponseEntity<Object> getShopsByFilter(@RequestBody ShopFilterRequest shopFilterRequest){

        try {

            return new ResponseEntity<>(shopService.getShopsByFilter(shopFilterRequest), HttpStatus.OK);


        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }



    }



}
