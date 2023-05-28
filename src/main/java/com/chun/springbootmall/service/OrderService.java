package com.chun.springbootmall.service;

import com.chun.springbootmall.dto.CreateOrderRequest;
import com.chun.springbootmall.model.Order;

public interface OrderService {


    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
