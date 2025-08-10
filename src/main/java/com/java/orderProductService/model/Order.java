package com.java.orderProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "orderstatus")
@Data
public class Order{
    @Id
    long id ;
    long productId;
    Status status;
}
