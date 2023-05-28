package com.chun.springbootmall.service.impl;

import com.chun.springbootmall.dao.OrderDao;
import com.chun.springbootmall.dao.ProductDao;
import com.chun.springbootmall.dto.BuyItem;
import com.chun.springbootmall.dto.CreateOrderRequest;
import com.chun.springbootmall.model.Order;
import com.chun.springbootmall.model.OrderItem;
import com.chun.springbootmall.model.Product;
import com.chun.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public Order getOrderById(Integer orderId) {
      Order order = orderDao.getOrderById(orderId);
      List<OrderItem> orderItemList = orderDao.getOrderItemByOrderId(orderId);

      order.setOrderItemList(orderItemList);
      return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount =0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for(BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product =productDao.getProductById(buyItem.getProductId());

            // 計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            // 轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);

        }

        // 創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);
        orderDao.createOrderItems(orderId, orderItemList);
        return orderId;


    }
}
