package com.Basil.BraberShop.services;


import com.Basil.BraberShop.Excptions.NotFoundException;
import com.Basil.BraberShop.dto.request.AddShopServiceRequest;
import com.Basil.BraberShop.dto.request.ServicesFilterRequest;
import com.Basil.BraberShop.dto.request.ShopAndServiceFilterRequest;
import com.Basil.BraberShop.models.Shop;
import com.Basil.BraberShop.models.ShopServices;
import com.Basil.BraberShop.repositories.ServiceShopRepository;
import com.Basil.BraberShop.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesShopServiceImpl  implements  ServicesShopService {

    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ShopService shopService;
    @Autowired
    ServiceShopRepository serviceShopRepository;
    @Override
    public void AddServiceToShop(AddShopServiceRequest shopServiceRequest) throws ClassNotFoundException {
        try {


            Optional<Shop> shop = shopRepository.findById(shopServiceRequest.getShop_id());
            if (shop.isPresent()) {
                ShopServices shopServices = new ShopServices();

                shopServices.setServiceName(shopServiceRequest.getService_name());
                shopServices.setService_type(shopServiceRequest.getService_type());
                shopServices.setCost(shopServiceRequest.getCost());
                shopServices.setDuration(shopServiceRequest.getService_duration());
                serviceShopRepository.save(shopServices);
                shop.get().getShopServicesList().add(shopServices);
                shopRepository.save(shop.get());
            }
        }catch (Exception e){
            throw new ClassNotFoundException("shop does not exist ");
        }


    }





    @Override
    public void DeleteById(Long Service_id,Long Shop_id) {
        try {
          Optional<Shop> shop =shopRepository.findById(Shop_id);
           ShopServices shopServices=serviceShopRepository.getById(Service_id);
if (shop.isPresent()){

    shop.get().RemoveService(shopServices);
}
serviceShopRepository.deleteById(Service_id);



        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public ShopServices getServiceById(Long id) {
        try {
            Optional<ShopServices> shopServices =serviceShopRepository.findById(id);
            if (shopServices.isPresent()){
                return shopServices.get();
            }
            else
                throw  new NotFoundException("Service does not exist");

        } catch (  NotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateService(ShopServices shopServices) {
        ShopServices shopServices1=serviceShopRepository.getById(shopServices.getId());

        shopServices1.setServiceName(shopServices.getServiceName());
        shopServices1.setService_type(shopServices.getService_type());
        shopServices1.setDuration(shopServices.getDuration());
        shopServices1.setShopList(shopServices1.getShopList());
        shopServices1.setCost(shopServices.getCost());
        serviceShopRepository.save(shopServices1);

    }

    @Override
    public List<ShopServices> ServiceFilter(ServicesFilterRequest servicesFilterRequest) {
        List<ShopServices> FinalResult=new ArrayList<>();
        try {


            if (servicesFilterRequest.getCost() != null && servicesFilterRequest.getService_name() != null) {
                FinalResult = serviceShopRepository.findByServiceNameContainingAndCostLessThanEqual(servicesFilterRequest.getService_name(), servicesFilterRequest.getCost());
            }
            if (servicesFilterRequest.getCost() != null) {
                FinalResult = serviceShopRepository.findByCostLessThanEqual(servicesFilterRequest.getCost());

            }
            if (servicesFilterRequest.getService_name() != null) {
                FinalResult = serviceShopRepository.findByCostLessThanEqual(servicesFilterRequest.getCost());
            }


        }catch (Exception e){
            e.printStackTrace();


        }

           return  FinalResult;


    }

    @Override
    public   List<Shop> ShopAndServiceFilter(ShopAndServiceFilterRequest shopAndServiceFilterRequest) {
        List<Shop> FinalResultNoServiceFound= new ArrayList<>();
        List<Shop> FilterByShopList=new ArrayList<>();
        List<ShopServices> FilterResult =new ArrayList<>();
        List<Shop> FinalResult= new ArrayList<>();


        if (shopAndServiceFilterRequest.shop_filter_request_is_set()) {
         FilterByShopList = shopService.getShopsByFilter(shopAndServiceFilterRequest.getShopFilterRequest());
         FinalResultNoServiceFound.add((Shop) FilterByShopList);
        }
        else {
            FilterResult = this.ServiceFilter(shopAndServiceFilterRequest.getServicesFilterRequest());
            for (ShopServices shopServices: FilterResult) {
                FinalResult.add((Shop) shopServices.getShopList());

            }
            return  FinalResult;
        }

        try{

         if (!FilterByShopList.isEmpty()){
             if (shopAndServiceFilterRequest.service_filter_request_is_set()) {
                 if (shopAndServiceFilterRequest.getServicesFilterRequest().getCost() != null && shopAndServiceFilterRequest.getServicesFilterRequest().getService_name() != null) {
                     List<ShopServices> FilterShopByServices = serviceShopRepository.findByShopListInAndCostAndServiceNameContaining(FilterByShopList, shopAndServiceFilterRequest.getServicesFilterRequest().getCost(), shopAndServiceFilterRequest.getServicesFilterRequest().getService_name());
                     FilterResult = FilterShopByServices;
                 }
                 if (shopAndServiceFilterRequest.getServicesFilterRequest().getCost() != null) {
                     List<ShopServices> FilterShopByServices = serviceShopRepository.findByShopListInAndCostLessThanEqual(FilterByShopList, shopAndServiceFilterRequest.getServicesFilterRequest().getCost());
                     FilterResult = FilterShopByServices;

                 }
                 if (shopAndServiceFilterRequest.getServicesFilterRequest().getService_name() != null) {
                     List<ShopServices> FilterShopByServices = serviceShopRepository.findByShopListInAndServiceNameContaining(FilterByShopList, shopAndServiceFilterRequest.getServicesFilterRequest().getService_name());
                     FilterResult = FilterShopByServices;
                 }

                 for (ShopServices shopServices : FilterResult) {
                     FinalResult.add((Shop) shopServices.getShopList());
                 }


               }
             else
                 return FinalResultNoServiceFound;
         }

     }catch (Exception e){
         e.printStackTrace();
         return new ArrayList<>();

     }
        return FinalResult;

    }


}
