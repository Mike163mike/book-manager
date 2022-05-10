package com.example.mike.bookmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String greeting(@RequestParam(name = "surname", required = false) String surname,
                           @RequestParam(name = "name", required = false) String name,
                           Model model) {
        model.addAttribute("surname" , surname);
        model.addAttribute("name", name);
        return "helloPage";
    }
}
