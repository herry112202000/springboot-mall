package com.chun.springbootmall.rowmapper;

import com.chun.springbootmall.constant.ProductCategory;
import com.chun.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//泛型<Product>:表示要轉換成Product這個java class
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        //可以從rs參數裡,取得資料庫查詢出來的數據,將她儲存在product變數裡
        Product product = new Product();

        //取得product_id這個欄位的數據
        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("product_name"));


        //將資料庫取出來的String類型的字串轉換成ProductCategory的Enum值,然後把她傳到set方法去做設定
        String categoryStr =rs.getString("category");
        ProductCategory category = ProductCategory.valueOf(categoryStr);
        product.setCategory(category);


//        product.setCategory(ProductCategory.valueOf(rs.getString("category")));



        product.setImageUrl(rs.getString("image_url"));
        product.setPrice(rs.getInt("price"));
        product.setStock(rs.getInt("stock"));
        product.setDescription(rs.getString("description"));
        product.setCreateDate(rs.getTimestamp("created_date"));
        product.setLastModifiedDate(rs.getTimestamp("last_modified_date"));
        return product;
    }
}
