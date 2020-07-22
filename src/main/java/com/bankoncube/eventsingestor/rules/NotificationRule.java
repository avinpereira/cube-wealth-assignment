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
    private String description = "Trigger a push notification on every {constraint1} bill pay event for the user";
    private Integer constraint1 = 1;
    private Integer constraint2 = 0;

    @Autowired
    public NotificationRule(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void implementRule(Customer customer) {
        if(customer.getEvents().isEmpty() || customer.getEvents().size() <= this.constraint1) notificationService.sendPushNotification("Congrats on your first Event");
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

    @Override
    public void setConstraint1(Integer constraint1) {
        this.constraint1 = constraint1;
    }

    @Override
    public Integer getConstraint1() {
        return this.constraint1;
    }

    @Override
    public void setConstraint2(Integer constraint2) {
        this.constraint2 = constraint2;
    }

    @Override
    public Integer getConstraint2() {
        return this.constraint2;
    }
}
