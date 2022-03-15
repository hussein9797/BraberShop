package com.Basil.BraberShop.Excptions;

public class ThisDateIsOccupied extends RuntimeException {
    public ThisDateIsOccupied(String message){
        super(message);
    }
}
