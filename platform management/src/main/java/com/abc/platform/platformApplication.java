package com.abc.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.abc.platform.dao")
public class  platformApplication {

    public static void main(String[] args) {
        SpringApplication.run(platformApplication.class, args);
    }

}
