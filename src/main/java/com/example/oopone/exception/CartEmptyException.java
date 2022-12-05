package com.example.oopone.exception;

public class CartEmptyException extends RuntimeException{

    private String message;
    public CartEmptyException(){}

    public CartEmptyException(String msg){
        super(msg);
        this.message = msg;
    }
}
