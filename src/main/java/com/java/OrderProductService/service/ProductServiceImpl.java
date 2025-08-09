package com.java.OrderProductService.service;

import com.java.OrderProductService.model.Product;
import com.java.OrderProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.saveAndFlush(product);
    }
}
