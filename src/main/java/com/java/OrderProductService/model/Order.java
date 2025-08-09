package com.java.OrderProductService.model;

public record Order(int id , String productId, Status status) {
}
