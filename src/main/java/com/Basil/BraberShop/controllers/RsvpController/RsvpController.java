package com.Basil.BraberShop.controllers.RsvpController;

import com.Basil.BraberShop.dto.request.BookingRequest;
import com.Basil.BraberShop.services.RsvpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Rsvp")
public class RsvpController {


    @Autowired
    RsvpService rsvpService;




    @PostMapping("/book")
    public ResponseEntity<Object> Book(@RequestBody BookingRequest bookingRequest){

        try {
            rsvpService.Book(bookingRequest);

            return new ResponseEntity<>("{ \"message\": \"booking success \" }", HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);


        }


    }
    @GetMapping("/getMyRsvp/{UserName}")
    public ResponseEntity<Object> getMyRsvp(@PathVariable ("UserName") String UserName){

        try {


            return new ResponseEntity<>(rsvpService.getMyRsvp(UserName), HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);


        }


    }   @GetMapping("/getShopRsvp/{UserName}")
    public ResponseEntity<Object> getMyRsvpShop(@PathVariable ("UserName") String UserName){

        try {


            return new ResponseEntity<>(rsvpService.getMyRsvpShop(UserName), HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);


        }


    }

        @DeleteMapping("deleteRsvp/{id}")
    public ResponseEntity<Object> deleteRsvp(@PathVariable ("id")  Long id){

        try {
            rsvpService.deleteRsvp(id);


            return new ResponseEntity<>("{ \"message\": \"deleted successfully \" }", HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);


        }


    }





}
