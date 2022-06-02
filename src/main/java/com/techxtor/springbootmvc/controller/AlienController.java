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

    /*@RequestMapping("/add-alien")
    public String AddAlien(@RequestParam("aId") int aId, @RequestParam("aName") String aName, Model m) {
        Alien a = new Alien();
        a.setaId(aId);
        a.setaName(aName);
        m.addAttribute("alien", a);
        return "alien-result";
    }
*/
    // same as above - Replaced @RequestParam with POJO/Model Class, provided.. inputs are same as Alien's attribute
    // ${alien}
   /* @RequestMapping("/add-alien")
    public String AddAlien(Alien a) {
        return "alien-result";
    }*/

   // ${a1}
   @RequestMapping("/add-alien")
   public String AddAlien(@ModelAttribute("a1") Alien a) {
       return "alien-result";
   }
}
