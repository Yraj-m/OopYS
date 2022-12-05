package com.example.oopone.exception;

public class QuantityExceedsException extends RuntimeException{
    private String message;
    public QuantityExceedsException(){}

    public QuantityExceedsException(String msg){
        super(msg);
        this.message = msg;
    }
}
