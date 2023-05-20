package com.chun.springbootmall.dao.impl;

import com.chun.springbootmall.dao.ProductDao;
import com.chun.springbootmall.model.Product;
import com.chun.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {


        String sql = "SELECT product_id, product_name, category, image_url, price, stock, " +
                "description, created_date, last_modified_date " +
                "FROM product " +
                "WHERE product_id = :productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        //查詢這一筆商品的數據, 第三個參數轉換數據的rowmapper:將資料庫所查詢出來的結果 去轉換成java object
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        //取得第一個值回傳回去
        if(productList.size() >0){
            return productList.get(0);
        }else {
            return null;
        }
    }
}
