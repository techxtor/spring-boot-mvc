package com.techxtor.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String Home() {
        System.out.println("Home Page requested");
        return "index.jsp";
    }
}
