package com.Basil.BraberShop.repositories;

import com.Basil.BraberShop.models.ShopRSVP;
import com.Basil.BraberShop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RsvpRepository extends JpaRepository<ShopRSVP,Long> {

   List<ShopRSVP> findAllByUser(User user);


}
