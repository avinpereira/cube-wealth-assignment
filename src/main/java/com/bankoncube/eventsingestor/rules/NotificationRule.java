package com.bankoncube.eventsingestor.rules;

import com.bankoncube.eventsingestor.entity.Customer;
import com.bankoncube.eventsingestor.entity.Event;
import com.bankoncube.eventsingestor.rule_framework.Rule;
import com.bankoncube.eventsingestor.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationRule implements Rule {

    private NotificationService notificationService;
    private boolean isEnabled;
    private String description = "This is a Notification Rule";

    @Autowired
    public NotificationRule(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void implementRule(Customer customer) {
        if(customer.getEvents().isEmpty()) notificationService.sendPushNotification("Congrats on your first Event");
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
}
