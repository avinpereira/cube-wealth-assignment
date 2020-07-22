package com.bankoncube.eventsingestor.dto.model;


public class RuleWithSelection {

    public String getRuleID() {
        return ruleID;
    }

    public void setRuleID(String ruleID) {
        this.ruleID = ruleID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = (status) ? "ENABLED" : "DISABLED";
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Integer getConstraint1() {
        return constraint1;
    }

    public void setConstraint1(Integer constraint1) {
        this.constraint1 = constraint1;
    }

    public Integer getConstraint2() {
        return constraint2;
    }

    public void setConstraint2(Integer constraint2) {
        this.constraint2 = constraint2;
    }

    public String ruleID;
    public String description;
    public String status;
    public Boolean selected;
    public Integer constraint1;


    public Integer constraint2;


    public RuleWithSelection() {
    }

    public RuleWithSelection(String ruleID, String description, Boolean status, Boolean selected, Integer constraint1, Integer constraint2) {
        this.ruleID = ruleID;
        this.description = description;
        this.status = (status) ? "ENABLED" : "DISABLED";
        this.selected = selected;
        this.constraint1 = constraint1;
        this.constraint2 = constraint2;
    }


}
