package com.chun.springbootmall.dao;

import com.chun.springbootmall.dto.CreateOrderRequest;
import com.chun.springbootmall.model.Order;
import com.chun.springbootmall.model.OrderItem;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public interface OrderDao {

    List<OrderItem> getOrderItemByOrderId(Integer orderId);
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);


}
