package com.java.orderProductService.repository;

import com.java.orderProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product saveAndFlush(Product product);
}
