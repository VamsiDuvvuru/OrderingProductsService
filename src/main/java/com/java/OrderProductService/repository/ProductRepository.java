package com.java.OrderProductService.repository;

import com.java.OrderProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product saveAndFlush(Product product);
}
