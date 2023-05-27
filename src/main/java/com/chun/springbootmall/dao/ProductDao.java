package com.chun.springbootmall.dao;

import com.chun.springbootmall.dto.ProductQueryParams;
import com.chun.springbootmall.dto.ProductRequest;
import com.chun.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);
    List<Product> getProducts(ProductQueryParams productQueryParams);

     Product getProductById(Integer productId);
     Integer createProduct(ProductRequest productRequest);

     void updateProduct(Integer productId,ProductRequest productRequest);

     void deleteProductById(Integer productId);
}
