package com.chun.springbootmall.controller;

import com.chun.springbootmall.dto.ProductRequest;
import com.chun.springbootmall.model.Product;
import com.chun.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    ===================================測試練習===================================================
//    @PostMapping("/products")
//    public ResponseEntity<Product> addData(@RequestParam("price") Integer price,
//                                @RequestParam("productname") String productname) {
//
//        System.out.println(String.format("price: %s , productname: %s",price,productname));
//        Product product = new Product();
//
//        product.setPrice(1000);
//        product.setProductName("醬油");
//
//
//        return ResponseEntity.status(HttpStatus.OK).body(product);
//    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct (@RequestBody @Valid ProductRequest productRequest){
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }



}
