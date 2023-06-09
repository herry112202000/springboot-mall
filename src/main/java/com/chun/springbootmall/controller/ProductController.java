package com.chun.springbootmall.controller;

import com.chun.springbootmall.constant.ProductCategory;
import com.chun.springbootmall.dto.ProductQueryParams;
import com.chun.springbootmall.dto.ProductRequest;
import com.chun.springbootmall.model.Product;
import com.chun.springbootmall.service.ProductService;
import com.chun.springbootmall.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @Validated
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
            // 查詢條件 Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,
            // 排序 Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort,
            // 分頁  Pagination
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset){



        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);



        List<Product> productList = productService.getProducts(productQueryParams);

        Integer total = productService.countProduct(productQueryParams);

        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }


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

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId ,
                                                 @RequestBody @Valid ProductRequest productRequest){

        //檢查 product 是否存在
        Product product = productService.getProductById(productId);

        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //修改商品數據
        //更新號碼為productId ,她要修改的參數物件productRequest
        productService.updateProduct( productId ,productRequest);

        //更新更新後查詢productId
        Product updateproduct = productService.getProductById(productId);
        //返回狀態碼及修改後的值updateproduct
        return ResponseEntity.status(HttpStatus.OK).body(updateproduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
