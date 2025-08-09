package com.java.orderProductService.service;

import com.java.orderProductService.model.Product;
import com.java.orderProductService.repository.ProductRepository;
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
