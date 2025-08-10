package com.java.orderProductService.controller;


import com.java.orderProductService.OrderProductServiceApplication;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = OrderProductServiceApplication.class)
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void addProducts() throws Exception {
        String jsonPayload = """
                {
                  "id": 1,
                  "name": "apple",
                  "price": 1000
                }
                """;
        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(content().string("product is added successfully"));

        jsonPayload = """
                {
                  "id": 100,
                  "productId": "1"
                }
                """;
        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(content().string("Order is added successfully"));
    }

    @Test
    @Order(2)
    void addProductsWithInvalidProductId() throws Exception {
        String jsonPayload = """
                {
                  "id": 10000,
                  "productId": "2"
                }
                """;
        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().is4xxClientError())
                .andExpect(content().string("product  is not available in the store with productid 2"));
    }


    @Test
    @Order(3)
    void getOrderStatus() throws Exception {
        mockMvc.perform(get("/orders/{orderId}" , 100))
                .andExpect(status().isOk());
    }
}
