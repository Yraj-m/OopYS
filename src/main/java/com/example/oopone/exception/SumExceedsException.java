package com.example.oopone.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class SumExceedsException extends RuntimeException{
     private String message;
      public SumExceedsException(){}

      public SumExceedsException(String msg){
          super(msg);
          this.message = msg;
      }


}
