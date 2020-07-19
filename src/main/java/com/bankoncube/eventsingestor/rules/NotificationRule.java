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

    @Autowired
    public NotificationRule(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void implementRule(Event event, Customer customer) {
        if(customer.getEvents().isEmpty()) notificationService.sendPushNotification("Congrats on your first Event");
    }

    @Override
    public void enable(boolean isEnabled) {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
