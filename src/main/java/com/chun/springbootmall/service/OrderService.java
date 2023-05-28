package com.chun.springbootmall.service;

import com.chun.springbootmall.dto.CreateOrderRequest;
import com.chun.springbootmall.dto.OrderQueryParams;
import com.chun.springbootmall.model.Order;

import java.util.List;

public interface OrderService {


    Integer countOrder(OrderQueryParams orderQueryParams);
    List<Order> getOders(OrderQueryParams orderQueryParams);
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
