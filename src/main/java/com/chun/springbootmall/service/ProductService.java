package com.chun.springbootmall.service;

import com.chun.springbootmall.dto.ProductRequest;
import com.chun.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();
    public Product getProductById(Integer productId);
    public Integer createProduct(ProductRequest productRequest);
    public void updateProduct(Integer productId,ProductRequest productRequest);

    public void deleteProductById(Integer productId);
}
