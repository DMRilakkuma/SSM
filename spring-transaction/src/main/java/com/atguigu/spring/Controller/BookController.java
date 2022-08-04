package com.atguigu.spring.Controller;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-04 16:36
 * @Description:
 */

@Controller
public class BookController{

    @Autowired
    private BookService bookService;

    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId, bookId);
    }
}