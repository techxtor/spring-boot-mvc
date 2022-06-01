package com.techxtor.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AddNumbersController {
    @RequestMapping("/add-numbers")
    public String addNumbers(){
        return "add-numbers.jsp";
    }

    /*@RequestMapping("/add-result")
    public ModelAndView Add(@RequestParam("num1") int i, @RequestParam("num2") int j) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add-result.jsp");
        int num3 = i + j;
        mv.addObject("res", num3);
        return mv;
    }*/

    @RequestMapping("/add-result")
    public ModelAndView Add(@RequestParam("num1") int i, @RequestParam("num2") int j) {
        Map<String, Object> valuesMap = new HashMap<>();
        valuesMap.put("res", i+j);
        ModelAndView mv = new ModelAndView("add-result.jsp", valuesMap);
        return mv;
    }
}
