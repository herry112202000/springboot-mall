package com.chun.springbootmall.dao;

import com.chun.springbootmall.constant.ProductCategory;
import com.chun.springbootmall.dto.ProductRequest;
import com.chun.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductCategory category, String search);

     Product getProductById(Integer productId);
     Integer createProduct(ProductRequest productRequest);

     void updateProduct(Integer productId,ProductRequest productRequest);

     void deleteProductById(Integer productId);
}
