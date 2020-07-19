package com.bankoncube.eventsingestor.rule_framework;

import com.bankoncube.eventsingestor.entity.Customer;
import com.bankoncube.eventsingestor.entity.Event;

public interface Rule {
    void implementRule(Event event, Customer customer);
    void enable(boolean isEnabled);
    boolean isEnabled();
}
