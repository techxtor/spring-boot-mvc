package com.techxtor.springbootmvc.controller;

import com.techxtor.springbootmvc.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlienController {
    @RequestMapping(value = "/alien")
    public String Alien() {
        return "add-alien";
    }

    @RequestMapping("/add-alien")
    public String AddAlien(@ModelAttribute("a1") Alien a) {
        return "alien-result";
    }

    // Spring Framework calls this before any listener is called
    @ModelAttribute
    public void modelData(Model m) {
        m.addAttribute("name", "Manish");
    }
}
