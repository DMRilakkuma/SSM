package com.mayikt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-14 23:08
 * @Description:
 */


@SpringBootApplication
@MapperScan("com.mayikt.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}