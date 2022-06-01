package com.techxtor.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AddNumbersController {
    @RequestMapping("/add-numbers")
    public String addNumbers(){
        return "add-numbers.jsp";
    }

    // using normal servlet
   /* @RequestMapping("/add-result")
    public String Add(HttpServletRequest request){
        int i = Integer.parseInt(request.getParameter("num1"));
        int j = Integer.parseInt(request.getParameter("num2"));
        int num3 = i+j;
        HttpSession session = request.getSession();
        session.setAttribute("res", num3);
        return "add-result.jsp";
    }*/

    // using @RequestParam
    @RequestMapping("/add-result")
    public String Add(@RequestParam("num1") int i, @RequestParam("num2") int j, HttpSession session){
        int num3 = i+j;
        session.setAttribute("res", num3);
        return "result.jsp";
    }
}
