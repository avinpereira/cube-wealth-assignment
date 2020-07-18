package com.bankoncube.eventsingestor.rules;

import com.bankoncube.eventsingestor.entity.Event;
import com.bankoncube.eventsingestor.rule_framework.Rule;
import org.springframework.stereotype.Component;

@Component
public class SomeOtherRule implements Rule {

    private boolean isEnabled;

    @Override
    public Event implementRule(Event event) {
        return null;
    }

    @Override
    public void enable(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
