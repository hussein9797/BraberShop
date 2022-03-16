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

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('shop_write')")
   // @PreAuthorize("hasAnyRole('SHOP_OWNER')")
    ResponseEntity<Object> addShop(@RequestBody AddShopRequest addShopRequest){

        try {
            shopService.updateShop(addShopRequest);
            return new ResponseEntity<>("{ \"message\": \"updated  successfully \" }", HttpStatus.OK);


        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }



    }
    @PostMapping("/getAll")
    @PreAuthorize("hasAnyRole('VISITOR')")

    ResponseEntity<Object> getAllShops(){

        try {

            return new ResponseEntity<>(shopService.getAllShop(), HttpStatus.OK);


        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }



    }
    @PostMapping("/shop_filter")
    @PreAuthorize("hasAnyRole('VISITOR')")
    ResponseEntity<Object> getShopsByFilter(@RequestBody ShopFilterRequest shopFilterRequest){

        try {

            return new ResponseEntity<>(shopService.getShopsByFilter(shopFilterRequest), HttpStatus.OK);


        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }



    }
    @GetMapping("/getShopByUser/{UserName}")
    @PreAuthorize("hasAuthority('shop_write')")
    ResponseEntity<Object> getShopByUserName(@PathVariable ("UserName")  String UserName){

        try {

            return new ResponseEntity<>(shopService .getShopByUserName(UserName), HttpStatus.OK);


        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }



    }



}
