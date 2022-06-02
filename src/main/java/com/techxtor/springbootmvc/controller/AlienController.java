package com.techxtor.springbootmvc.controller;

import com.techxtor.springbootmvc.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class AlienController {
    @RequestMapping(value = "/alien")
    public String Alien() {
        return "add-alien";
    }

    /*@RequestMapping(value = "/add-alien", method = RequestMethod.POST)
    public String AddAlien(@ModelAttribute("a1") Alien a) {
        return "alien-result";
    }*/

    @PostMapping(value = "/add-alien")
    public String AddAlien(@ModelAttribute("a1") Alien a) {
        return "alien-result";
    }

    @GetMapping("get-aliens")
    public String getAlien(Model m) {
        List<Alien> alienList = Arrays.asList(new Alien(101, "Techxtor"), new Alien(102, "Manish"));
        m.addAttribute("result", alienList);
        return "show-aliens";
    }
}
