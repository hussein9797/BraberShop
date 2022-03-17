package com.Basil.BraberShop.services;


import com.Basil.BraberShop.Excptions.NotFoundException;
import com.Basil.BraberShop.dto.request.BookingRequest;
import com.Basil.BraberShop.dto.response.Location;
import com.Basil.BraberShop.dto.response.RsvpResponse;
import com.Basil.BraberShop.models.Shop;
import com.Basil.BraberShop.models.ShopRSVP;
import com.Basil.BraberShop.models.ShopServices;
import com.Basil.BraberShop.models.User;
import com.Basil.BraberShop.repositories.RsvpRepository;
import com.Basil.BraberShop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RsvpServiceImpl implements RsvpService {
    @Autowired
    ShopService shopService;
    @Autowired
    ServicesShopService servicesShopService;
    @Autowired
    RsvpRepository rsvpRepository;
    @Autowired
    UserRepository userRepository;



    @Override
    @Transactional
    public void Book(BookingRequest bookingRequest) {
        ShopRSVP shopRSVP = new ShopRSVP();
        try{
            User user=userRepository.findByUsername(bookingRequest.getUser_name());

            Shop ShopToBookIn= shopService.getShopById(bookingRequest.getShop_id());
            ShopServices ChosenService= servicesShopService.getServiceById(bookingRequest.getServices_id());
            shopRSVP.setShop(ShopToBookIn);
            shopRSVP.setShopServices(ChosenService);
            shopRSVP.setRsvpDate(bookingRequest.getRsvp_date());
            shopRSVP.setUser(user);
            rsvpRepository.save(shopRSVP);





            }catch (NotFoundException e)
             {
                e.printStackTrace();

             }









    }

    @Override
    public List<RsvpResponse> getMyRsvp(String Username) {
        try{
            User user=userRepository.findByUsername(Username);
            List< ShopRSVP> rsvp=    rsvpRepository.findAllByUser(user);
           List<RsvpResponse>  result =new ArrayList<>();
            for (ShopRSVP  r: rsvp
                 ) {
                Location location=new Location();
                location.setLat(r.getShop().getLat());
                location.setLng(r.getShop().getLng());
                RsvpResponse rsvpResponse1 =new RsvpResponse(user.getUsername(),r.getShopServices().getServiceName(),r.getShopServices().getCost(),r.getShopServices().getDuration(),r.getShop().getShopName(),r.getShopServices().getService_type(),r.getRsvpDate(),r.getShop().getCity(),location,r.getShop().getRate());
                result.add(rsvpResponse1);


            }
            return result;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<RsvpResponse> getMyRsvpShop(String Username) {
        try{

            Shop shop =shopService.getShopByUserName(Username);
            List< ShopRSVP> rsvp=    rsvpRepository.findAllByShop (shop);
           List<RsvpResponse>  result =new ArrayList<>();
            for (ShopRSVP  r: rsvp
                 ) {
                Location location=new Location();
                location.setLat(r.getShop().getLat());
                location.setLng(r.getShop().getLng());
                RsvpResponse rsvpResponse1 =new RsvpResponse(shop.getShopName(),r.getShopServices().getServiceName(),r.getShopServices().getCost(),r.getShopServices().getDuration(),r.getShop().getShopName(),r.getShopServices().getService_type(),r.getRsvpDate(),r.getShop().getCity(),location,r.getShop().getRate());
                result.add(rsvpResponse1);


            }
            return result;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteRsvp(Long id) {
        try{

            rsvpRepository.deleteById(id);
        }catch (Exception e){

            e.printStackTrace();
        }

    }

}
