package com.chun.springbootmall.service.impl;

import com.chun.springbootmall.dao.ProductDao;
import com.chun.springbootmall.model.Product;
import com.chun.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
