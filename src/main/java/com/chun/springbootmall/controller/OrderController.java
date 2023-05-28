package com.chun.springbootmall.controller;

import com.chun.springbootmall.dao.OrderDao;
import com.chun.springbootmall.dto.BuyItem;
import com.chun.springbootmall.dto.CreateOrderRequest;
import com.chun.springbootmall.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest){

       Integer orderId =orderService.createOrder(userId, createOrderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderId);

    }
}
