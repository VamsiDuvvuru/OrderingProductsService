package com.java.orderProductService.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String s, long productId) {
        super(s + productId);
    }
}
