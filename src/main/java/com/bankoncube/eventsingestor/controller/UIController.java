package com.bankoncube.eventsingestor.controller;

import com.bankoncube.eventsingestor.dto.model.RuleWithSelection;
import com.bankoncube.eventsingestor.dto.model.RulesWithSelectionListWrapper;
import com.bankoncube.eventsingestor.rule_framework.Rule;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

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
        allRulesWithSelection.clear();
        rules.forEach(r -> allRulesWithSelection.add(new RuleWithSelection(null, r.getDescription(), r.isEnabled(), false, r.getConstraint1(), r.getConstraint2())));
        RulesWithSelectionListWrapper wrapper = new RulesWithSelectionListWrapper();
        wrapper.setRuleList(allRulesWithSelection);
        model.addAttribute("wrapper", wrapper);
        return "rules";
    }



    @RequestMapping(value = "/api/rules/submitQuery", method = RequestMethod.POST)
    public String processQuery(@ModelAttribute RulesWithSelectionListWrapper wrapperResponse, Model model) {
        ArrayList<RuleWithSelection> ruleList = wrapperResponse.getRuleList();
        for(RuleWithSelection updatedRule : ruleList){
            rules.stream()
                    .filter(r -> updatedRule.getDescription().equals(r.getDescription()))
                    .map(r -> this.updateConstraints(r, updatedRule))
                    .filter(r -> updatedRule.getSelected())
                    .forEach(Rule::toggle);
        }
        allRulesWithSelection.clear();
        rules.forEach(r -> allRulesWithSelection.add(new RuleWithSelection(null, r.getDescription(), r.isEnabled(), false, r.getConstraint1(), r.getConstraint2())));
        RulesWithSelectionListWrapper wrapper = new RulesWithSelectionListWrapper();
        wrapper.setRuleList(allRulesWithSelection);
        model.addAttribute("wrapper", wrapper);
        return "rules";
    }

    private Rule updateConstraints(Rule rule, RuleWithSelection updatedRule) {
        rule.setConstraint1(updatedRule.getConstraint1());
        rule.setConstraint2(updatedRule.getConstraint2());
        return rule;
    }


}
