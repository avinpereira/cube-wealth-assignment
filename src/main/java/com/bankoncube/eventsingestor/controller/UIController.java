package com.bankoncube.eventsingestor.controller;

import com.bankoncube.eventsingestor.dto.response.ResponseElement;
import com.bankoncube.eventsingestor.rule_framework.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UIController {

    @Autowired
    List<Rule> rules;
    @GetMapping("/api/admin")
    public String hello(Model model){
        model.addAttribute("rule");
        model.addAttribute("message", "Hello World");
        return "helloworld";
    }

    @GetMapping("/api/rules")
    public String rules(Model model){
        List<ResponseElement> responseElementList = new ArrayList<>();
        rules.forEach(r -> responseElementList.add(new ResponseElement(r.getDescription(),r.isEnabled())));
        model.addAttribute("rules", responseElementList);
        return "rules";
    }
}
