package com.techxtor.springbootmvc.controller;

import com.techxtor.springbootmvc.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
}
