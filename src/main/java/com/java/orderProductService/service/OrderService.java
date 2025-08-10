package com.java.orderProductService.service;

import com.java.orderProductService.model.Order;

public interface OrderService {
    void putOrder(Order order);

    String getOrderStatusById(long orderId);
}
