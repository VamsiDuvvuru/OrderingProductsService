package com.java.orderProductService.controller;

import com.java.orderProductService.model.Order;
import com.java.orderProductService.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<String> createOrder(@RequestBody Order order){
        orderService.putOrder(order);
        return new ResponseEntity<>("Order is added successfully" , HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<String> getOrderStatus(@PathVariable("orderId") long orderId){
        String orderStatus = orderService.getOrderStatusById(orderId);
        return new ResponseEntity<>(orderStatus , HttpStatus.OK);
    }

}
