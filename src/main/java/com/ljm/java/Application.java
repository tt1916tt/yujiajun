package com.ljm.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.ljm.java.filter")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
