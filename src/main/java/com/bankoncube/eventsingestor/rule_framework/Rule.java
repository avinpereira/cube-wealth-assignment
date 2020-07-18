package com.bankoncube.eventsingestor.rule_framework;

import com.bankoncube.eventsingestor.entity.Event;

public interface Rule {
    Event implementRule(Event event);
    void enable(boolean isEnabled);
    boolean isEnabled();
}
