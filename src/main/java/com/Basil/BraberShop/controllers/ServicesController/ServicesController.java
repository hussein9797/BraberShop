package com.Basil.BraberShop.controllers.ServicesController;


import com.Basil.BraberShop.dto.request.AddShopServiceRequest;
import com.Basil.BraberShop.dto.request.ShopAndServiceFilterRequest;
import com.Basil.BraberShop.models.ShopServices;
import com.Basil.BraberShop.services.ServicesShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
public class ServicesController {


    @Autowired
    ServicesShopService servicesShopService;


    @PostMapping("add")
    @PreAuthorize("hasAuthority('shop_write')")
        // @PreAuthorize("hasAnyRole('SHOP_OWNER')")
    ResponseEntity<Object> addService(@RequestBody AddShopServiceRequest shopServiceRequest) {

        try {
            servicesShopService.AddServiceToShop(shopServiceRequest);
            return new ResponseEntity<>("service added successfully ", HttpStatus.OK);


        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

    @DeleteMapping("delete/{service_id}/{shop_id}")
    @PreAuthorize("hasAuthority('shop_write')")
        // @PreAuthorize("hasAnyRole('SHOP_OWNER')")
    ResponseEntity<Object> deleteService(@PathVariable("service_id") Long service_id, @PathVariable("shop_id") Long shop_id) {

        try {
            servicesShopService.DeleteById(service_id, shop_id);

            return new ResponseEntity<>("service deleted  successfully ", HttpStatus.OK);


        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

    @PutMapping("update")
    @PreAuthorize("hasAuthority('shop_write')")
        // @PreAuthorize("hasAnyRole('SHOP_OWNER')")
    ResponseEntity<Object> deleteService(@RequestBody ShopServices shopServices) {

        try {
            servicesShopService.updateService(shopServices);

            return new ResponseEntity<>("service updated successfully ", HttpStatus.OK);


        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
    @GetMapping("services_filter")
    @PreAuthorize("hasAuthority('shop_write')")
        // @PreAuthorize("hasAnyRole('SHOP_OWNER')")
    ResponseEntity<Object> servicesFilter(@RequestBody ShopAndServiceFilterRequest shopAndServiceFilterRequest) {

        try {



            return new ResponseEntity<>(servicesShopService.ShopAndServiceFilter(shopAndServiceFilterRequest), HttpStatus.OK);


        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

}
