package com.java.orderProductService.service;

import com.java.orderProductService.model.Order;
import com.java.orderProductService.model.Status;
import com.java.orderProductService.repository.OrderRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
    public void performAsyncTask() {
        try {
            Thread.sleep(3000);
            updateOrderStatus(getOrders());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /*
     This method helps to fetch the orders which are in status of processing
     it return the list of those orders
     */
    public List<Order> getOrders(){
        return orderRepository.findByStatus(Status.PROCESSING);
    }

    private void updateOrderStatus(List<Order> orders){
        List<Status> availableStatuses = Arrays.asList(Status.COMPLETED, Status.FAILED);
        for(Order order : orders){
            //use random object to set the status randomly
            Random random = new Random();
            int randomIndex = random.nextInt(availableStatuses.size());
            Status randomStatus = availableStatuses.get(randomIndex);
            //set the status like here shown below
            order.setStatus(randomStatus);
            //update the order like shown below
            orderRepository.save(order);
        }
    }
}
