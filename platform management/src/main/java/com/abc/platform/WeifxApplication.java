package com.abc.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.abc.weifx.dao")
public class  WeifxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeifxApplication.class, args);
    }

}
