/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Goshgar
 */
@Controller
public class UserController {
    
    @RequestMapping("/user")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "cars";
    }
    
}
