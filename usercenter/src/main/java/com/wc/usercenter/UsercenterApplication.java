package com.wc.usercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wc.usercenter.mapper")
public class UsercenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsercenterApplication.class, args);
    }

}
