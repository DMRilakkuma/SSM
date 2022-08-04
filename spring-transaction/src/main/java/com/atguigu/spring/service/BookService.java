package com.atguigu.spring.service;

import org.springframework.stereotype.Service;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-04 16:37
 * @Description:
 */


public interface BookService {

    /* \
    *  买书
    * */
    void buyBook(Integer userId, Integer bookId);
}