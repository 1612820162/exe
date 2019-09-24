package com.example.exe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.exe.dao")
public class ExeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExeApplication.class, args);
    }

}
