package com.chun.springbootmall.service.impl;

import com.chun.springbootmall.dao.ProductDao;
import com.chun.springbootmall.dto.ProductRequest;
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



    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {

    }
}
