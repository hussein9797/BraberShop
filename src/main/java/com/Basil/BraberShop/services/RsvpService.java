package com.Basil.BraberShop.services;

import com.Basil.BraberShop.dto.request.BookingRequest;
import com.Basil.BraberShop.dto.response.RsvpResponse;

import java.util.List;

public interface RsvpService {
    void Book(BookingRequest bookingRequest);
    List<RsvpResponse> getMyRsvp(String userName);
    void deleteRsvp(Long id );
}
