package com.abc.Business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.abc.Business.dao")
public class BusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }

}
