package com.book.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("str","хело ворд");
        return "index";
    }
}
