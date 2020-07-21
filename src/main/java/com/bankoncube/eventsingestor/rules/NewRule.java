package com.bankoncube.eventsingestor.rules;

import com.bankoncube.eventsingestor.entity.Customer;
import com.bankoncube.eventsingestor.entity.Event;
import com.bankoncube.eventsingestor.rule_framework.Rule;
import com.bankoncube.eventsingestor.service.NotificationService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewRule implements Rule{
    private NotificationService notificationService;
    private boolean isEnabled;
    private String description = "This Description will be displayed on the Dashboard to the Admin";

    @Override
    public void implementRule(Customer customer) {
        List<Event> events = customer.getEvents();
        /* Implement some Rules based on the requirements */
        /* Ex: Sending Notification for the First Pay Event etc. . . */
    }

    @Override
    public void enable(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return  this.description;
    }

    @Override
    public void toggle() {
        this.isEnabled = !this.isEnabled;
    }
}