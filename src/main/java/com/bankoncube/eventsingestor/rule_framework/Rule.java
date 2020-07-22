package com.bankoncube.eventsingestor.rule_framework;

import com.bankoncube.eventsingestor.entity.Customer;

public interface Rule {
    void implementRule(Customer customer);
    void enable(boolean isEnabled);
    boolean isEnabled();
    void setDescription(String description);
    String getDescription();
    void toggle();
    void setConstraint1(Integer constraint1);
    Integer getConstraint1();
    void setConstraint2(Integer constraint2);
    Integer getConstraint2();
}
