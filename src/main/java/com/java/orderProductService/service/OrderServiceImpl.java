package com.java.orderProductService.service;

import com.java.orderProductService.exceptions.OrderNotFoundException;
import com.java.orderProductService.exceptions.ProductNotFoundException;
import com.java.orderProductService.model.Order;
import com.java.orderProductService.model.Product;
import com.java.orderProductService.model.Status;
import com.java.orderProductService.repository.OrderRepository;
import com.java.orderProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final ProductOrderAsyncService productOrderAsyncService;

    public OrderServiceImpl(OrderRepository orderRepository ,
                            ProductOrderAsyncService productOrderAsyncService,
                            ProductRepository productRepository){
        this.orderRepository = orderRepository;
        this.productOrderAsyncService = productOrderAsyncService;
        this.productRepository = productRepository;
    }

    /*
    * check product availability
    * Adding the order through OrderRepository
    * Always make sure the initial status of order is always PENDING
    * perform the async task
    */
    @Override
    public void putOrder(Order order) {
        checkProductAvailablity(order.getProductId());
        order.setStatus(Status.PENDING);
        orderRepository.saveAndFlush(order);
        productOrderAsyncService.performAsyncTask();
    }

    /*
    * fetch the ordre by order id
    * this method returns the status of the order*/
    @Override
    public String getOrderStatusById(long orderId) {
        Order order = orderRepository.getReferenceById(orderId);
        if(order == null){
            throw new OrderNotFoundException("the order is not found for order id {}" ,orderId);
        }
        return order.getStatus().toString();
    }

    /*
        first check if the ordered product is available
        if not please throw product not available exception
     */
    private boolean checkProductAvailablity(long productId){
        Product product = productRepository.getReferenceById(productId);
        if(product == null){
            throw new ProductNotFoundException("product with id {} is not available in the store" , productId);
        }
        return product != null;
    }
}
