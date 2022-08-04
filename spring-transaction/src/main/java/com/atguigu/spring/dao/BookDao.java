package com.atguigu.spring.dao;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-04 16:38
 * @Description:
 */


public interface BookDao {

    // 根据图书id查询图书价格
    Integer getPriceByBoolId(Integer userId, Integer bookId);

    // 更新图书的库存
    void updateStock(Integer bookId);


    // 更新用户的余额
    void updateBalance(Integer userId, Integer price);
}