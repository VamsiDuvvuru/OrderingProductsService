package com.java.orderProductService.exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String s) {
        super(s );
    }
}
