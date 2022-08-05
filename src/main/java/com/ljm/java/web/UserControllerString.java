package com.ljm.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("suser")
public class UserControllerString {


    @GetMapping("query/{id}")
    public String getUser(@PathVariable Long id){
        System.out.println("111");
        return "404";
    }
}
