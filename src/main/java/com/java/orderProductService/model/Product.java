package com.java.orderProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "product")
@Entity
@Data
public class Product {
    @Id
    long id;
    String name;
    int price;
}
