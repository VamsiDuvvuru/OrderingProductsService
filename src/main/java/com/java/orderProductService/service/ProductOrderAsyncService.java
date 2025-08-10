package com.java.orderProductService.service;

import com.java.orderProductService.model.Order;
import com.java.orderProductService.model.Status;
import com.java.orderProductService.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
public class ProductOrderAsyncService {

    private final OrderRepository orderRepository;

    public ProductOrderAsyncService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    /*
        This async task set the status of order randomly to completed or failed
        more details find in the below method implementation
     */
    @Async
    public void performAsyncTask(long orderId) {
        try {
            log.info("async job is started");
            Thread.sleep(5000);
            Optional<Order> order = getOrders(orderId);
            if(order.isEmpty()){
                log.warn("orders are not available");
                return;
            }
            log.info("order is :{}" , order);
            updateOrderStatus(order);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            log.info("async job is completed");
        }
    }

    /*
     This method helps to fetch the orders which are in status of processing
     it return the list of those orders
     */
    public Optional<Order> getOrders(long orderId){
        return orderRepository.findById(orderId);
    }

    private void updateOrderStatus(Optional<Order> orders){
        List<Status> availableStatuses = Arrays.asList(Status.COMPLETED, Status.FAILED);
        Order order = orders.get();
        log.info("Before order status  orderid {} , status{}",order.getProductId() , order.getStatus());
        Random random = new Random();
        int randomIndex = random.nextInt(availableStatuses.size());
        Status randomStatus = availableStatuses.get(randomIndex);
        //set the status like here shown below
        orders.get().setStatus(randomStatus);
        log.info("After order status  orderid {} , status{}",order.getProductId() , order.getStatus());
        //update the order like shown below
        orderRepository.save(order);
    }
}
