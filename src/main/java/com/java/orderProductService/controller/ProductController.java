package com.java.orderProductService.controller;

import com.java.orderProductService.model.Product;
import com.java.orderProductService.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*
    This controller method is used to add products sent from request
    it accepts parameter product as a body
    It returns OK in case of successful addition of product
     */
    @PostMapping("/products")
    public ResponseEntity<String> retrieveProductDetails(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>("product is added successfully", HttpStatus.OK);
    }
}
