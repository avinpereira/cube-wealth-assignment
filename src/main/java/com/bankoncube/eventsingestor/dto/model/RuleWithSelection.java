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

    public String ruleID;
    public String description;
    public String status;
    public Boolean selected;


    public RuleWithSelection() {
    }

    public RuleWithSelection(String ruleID, String description, Boolean status, Boolean selected) {
        this.ruleID = ruleID;
        this.description = description;
        this.status = (status) ? "ENABLED" : "DISABLED";
        this.selected = selected;
    }


}
