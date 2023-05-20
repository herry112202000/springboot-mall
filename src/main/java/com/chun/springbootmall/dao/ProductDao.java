package com.chun.springbootmall.dao;

import com.chun.springbootmall.model.Product;

public interface ProductDao {

    public Product getProductById(Integer productId);
}
