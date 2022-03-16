package com.Basil.BraberShop.services;



import com.Basil.BraberShop.Authentication.MyUserDetails;
import com.Basil.BraberShop.dto.request.ShopRegisterRequest;
import com.Basil.BraberShop.dto.request.UserRegisterRequest;
import com.Basil.BraberShop.enums.UserRole;
import com.Basil.BraberShop.models.Shop;
import com.Basil.BraberShop.models.User;
import com.Basil.BraberShop.repositories.ShopRepository;
import com.Basil.BraberShop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService,UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ShopRepository shopRepository;
  public static  Long userId;

    public UserDetailsServiceImpl() {
    }

 
    @Override
    public UserDetails loadUserByUsername(String user_name)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(user_name);

        userId=1L;

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }


    @Override
    public void registerUser(UserRegisterRequest userRegisterRequest) throws Exception {
        try {
            User user = new User();
            if (checkIfUserExist(userRegisterRequest.getUser_name()))
                throw new Exception("User with " + userRegisterRequest.getUser_name() + " is already exist");
            user.setUsername(userRegisterRequest.getUser_name());
            user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
            user.setEnabled(true);
            user.setUserRole(UserRole.VISITOR);//defualtRule
            userRepository.save(user);

        } catch (Exception e) {

            throw e;
        }
    }

public void registerShop(ShopRegisterRequest userRegisterRequest) throws Exception {
try {
    User user = new User();
    Shop shop =new Shop();
    if (checkIfUserExist(userRegisterRequest.getUser_name()))
        throw new Exception("User with " + userRegisterRequest.getUser_name() + " is already exist");
    user.setUsername(userRegisterRequest.getUser_name());
    user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
    user.setEnabled(true);
    user.setUserRole(UserRole.SHOP_OWNER);//defualtRule
    shop.setShopName(userRegisterRequest.getShop_name());
    shop.setOwner(user);
    userRepository.save(user);
    shopRepository.save(shop);

}catch ( Exception e){

throw  e;
}


    }

    @Override
    public boolean checkIfUserExist(String user_name) {
        return userRepository.findByUsername(user_name) != null;
    }

}