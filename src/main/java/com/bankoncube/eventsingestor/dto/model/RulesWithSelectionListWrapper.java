package com.bankoncube.eventsingestor.dto.model;

import lombok.Data;

import java.util.ArrayList;


public class RulesWithSelectionListWrapper {
    private ArrayList<RuleWithSelection> ruleList;

    public ArrayList<RuleWithSelection> getRuleList() {
        return ruleList;
    }

    public void setRuleList(ArrayList<RuleWithSelection> ruleList) {
        this.ruleList = ruleList;
    }
}