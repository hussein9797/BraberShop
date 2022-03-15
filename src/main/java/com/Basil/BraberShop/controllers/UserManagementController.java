package com.Basil.BraberShop.controllers;

import com.Basil.BraberShop.dto.request.ShopRegisterRequest;
import com.Basil.BraberShop.dto.request.UserRegisterRequest;
import com.Basil.BraberShop.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user_management")
public class UserManagementController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/user_register")
    ResponseEntity<Object> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) throws Exception {
        try {
            userDetailsService.registerUser(userRegisterRequest);
            return new ResponseEntity<>("massage :\"Registered Successfully\"", HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("massage :\"UserName Already Exist Please Choose Another UserName\"", HttpStatus.CONFLICT);


        }
    }
        @PostMapping("/shop_register")
         ResponseEntity<Object> shopRegister(@RequestBody ShopRegisterRequest shopRegisterRequest) {
        try {
            userDetailsService.registerShop(shopRegisterRequest);
            return new ResponseEntity<>("massage :\"Registered Successfully\"", HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("massage :\"UserName Already Exist Please Choose Another UserName\"", HttpStatus.CONFLICT);


        }


    }
}