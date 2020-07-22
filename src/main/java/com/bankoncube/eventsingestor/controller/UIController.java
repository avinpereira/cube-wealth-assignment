package com.bankoncube.eventsingestor.controller;

import com.bankoncube.eventsingestor.dto.model.RuleWithSelection;
import com.bankoncube.eventsingestor.dto.model.RulesWithSelectionListWrapper;
import com.bankoncube.eventsingestor.dto.response.ResponseElement;
import com.bankoncube.eventsingestor.rule_framework.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class UIController {

    private static ArrayList<RuleWithSelection> allRulesWithSelection = new ArrayList<>();

    @Autowired
    List<Rule> rules;

    @GetMapping("/api/admin")
    public String hello(Model model){
        model.addAttribute("rule");
        return "helloworld";
    }

    @GetMapping("/api/rules")
    public String rules(Model model){
        rules.forEach(r -> allRulesWithSelection.add(new RuleWithSelection(null, r.getDescription(), r.isEnabled(), false, r.getConstraint1(), r.getConstraint2())));
        RulesWithSelectionListWrapper wrapper = new RulesWithSelectionListWrapper();
        wrapper.setRuleList(allRulesWithSelection);
        model.addAttribute("wrapper", wrapper);
        return "rules";
    }



    @RequestMapping(value = "/api/rules/submitQuery", method = RequestMethod.POST)
    public String processQuery(@ModelAttribute RulesWithSelectionListWrapper wrapperResponse, Model model) {
        ArrayList<RuleWithSelection> ruleList = wrapperResponse.getRuleList();
        List<String> descriptions = ruleList.stream().map(RuleWithSelection::getDescription).collect(Collectors.toList());
        descriptions = descriptions.stream().filter(Objects::nonNull).collect(Collectors.toList());
        for(String desc : descriptions){
            rules.stream()
                    .filter(r -> desc.equals(r.getDescription()))
                    .forEach(Rule::toggle);
        }
        allRulesWithSelection.clear();
        rules.forEach(r -> allRulesWithSelection.add(new RuleWithSelection(null, r.getDescription(), r.isEnabled(), false, r.getConstraint1(), r.getConstraint2())));
        RulesWithSelectionListWrapper wrapper = new RulesWithSelectionListWrapper();
        wrapper.setRuleList(allRulesWithSelection);
        model.addAttribute("wrapper", wrapper);

        return "rules";
    }


}
