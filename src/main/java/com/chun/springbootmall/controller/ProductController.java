package com.chun.springbootmall.controller;

import com.chun.springbootmall.model.Product;
import com.chun.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //取得某一筆商品的數據:用GET方法請求
    //@GetMapping("/products/{productId}") :表示取得某一筆商品的數據
    @GetMapping("/products/{productId}")
    //@PathVariable Integer productId : 表示productId的值是從url路徑傳進來的
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
