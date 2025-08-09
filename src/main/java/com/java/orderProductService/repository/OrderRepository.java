package com.java.orderProductService.repository;

import com.java.orderProductService.model.Order;
import com.java.orderProductService.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

   Order saveAndFlush(Order order);

    List<Order> findByStatus(Status status);

}
