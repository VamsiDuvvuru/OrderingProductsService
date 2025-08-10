package com.java.orderProductService.service;

import com.java.orderProductService.exceptions.OrderNotFoundException;
import com.java.orderProductService.exceptions.ProductNotFoundException;
import com.java.orderProductService.model.Order;
import com.java.orderProductService.model.Product;
import com.java.orderProductService.model.Status;
import com.java.orderProductService.repository.OrderRepository;
import com.java.orderProductService.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
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
        //save the order status as pending
        orderRepository.save(order);
        //run the async job
        productOrderAsyncService.performAsyncTask(order.getId());
    }

    /*
    * fetch the order by order id
    * this method returns the status of the order
    */
    @Override
    public String getOrderStatusById(long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isEmpty()){
            log.warn("the given order is not available with order id{}",orderId);
            throw new OrderNotFoundException(String.format("the order is not found for order id {}" ,orderId));
        }
        return order.get().getStatus().toString();
    }

    /*
        first check if the ordered product is available
        if not please throw product not available exception
     */
    private void checkProductAvailablity(long productId){
        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty()){
            log.warn("product id is not available please change product id {}",productId);
            throw new ProductNotFoundException(String.format("product  is not available in the store with productid %d" , productId));
        }
    }
}
