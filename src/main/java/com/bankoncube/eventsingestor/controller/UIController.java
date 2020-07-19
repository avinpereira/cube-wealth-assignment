package com.bankoncube.eventsingestor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
    @GetMapping("/api/admin")
    public String hello(Model model){
        model.addAttribute("message", "Hello World");
        return "helloworld";
    }
}
