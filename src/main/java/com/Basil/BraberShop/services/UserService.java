package com.Basil.BraberShop.services;


import com.Basil.BraberShop.dto.request.UserRegisterRequest;

public interface UserService {

    void registerUser(UserRegisterRequest userRegisterRequest) throws Exception;

     boolean checkIfUserExist(String email);


}
