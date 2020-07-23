package com.bankoncube.eventsingestor.rule_framework;

import com.bankoncube.eventsingestor.entity.Customer;

public abstract class Rule {

    private boolean isEnabled;
    private String description;
    private Integer constraint1;
    private Integer constraint2;

    public abstract void implementRule(Customer customer);


    public void enable(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }


    public boolean isEnabled() {
        return this.isEnabled;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return  this.description;
    }


    public void toggle() {
        this.isEnabled = !this.isEnabled;
    }


    public void setConstraint1(Integer constraint1) {
        this.constraint1 = constraint1;
    }


    public Integer getConstraint1() {
        return this.constraint1;
    }


    public void setConstraint2(Integer constraint2) {
        this.constraint2 = constraint2;
    }


    public Integer getConstraint2() {
        return this.constraint2;
    }
}
