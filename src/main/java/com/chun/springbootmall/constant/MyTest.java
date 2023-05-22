package com.chun.springbootmall.constant;

public class MyTest {
    public static void main(String[] args) {
        ProductCategory Category = ProductCategory.FOOD;
        String s = Category.name();
        System.out.println(s); //FOOD

        //字串轉enum
        String s2 = "CAR";
        ProductCategory Category2 = ProductCategory.valueOf(s2);

    }
}
