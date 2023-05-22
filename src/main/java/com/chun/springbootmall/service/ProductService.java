package com.chun.springbootmall.service;

import com.chun.springbootmall.dto.ProductRequest;
import com.chun.springbootmall.model.Product;

public interface ProductService {
    public Product getProductById(Integer productId);
    public Integer createProduct(ProductRequest productRequest);
}
