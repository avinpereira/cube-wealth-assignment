package com.bankoncube.eventsingestor.rules;

import com.bankoncube.eventsingestor.entity.Customer;
import com.bankoncube.eventsingestor.entity.Event;
import com.bankoncube.eventsingestor.rule_framework.Rule;
import com.bankoncube.eventsingestor.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExcessivePayEventRule implements Rule {

    private NotificationService notificationService;
    private boolean isEnabled;
    private String description = "Alert user if 5 or more bill pay events of total value >= {constraint1} happen within {constraint2} minutes time window";
    private Integer constraint1 = 20000;
    private Integer constraint2 = 5;


    @Autowired
    public ExcessivePayEventRule(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void implementRule(Customer customer) {
        List<Event> eventList = customer.getEvents().stream()
                .filter(e -> "pay".equals(e.getVerb()))
                .filter(e -> Instant.now().minus(this.getConstraint2(), ChronoUnit.MINUTES).isBefore(e.getSourceTimestamp()))
                .collect(Collectors.toList());
        if(eventList.size() >= 5) {
            double doubleStream = eventList.stream()
                    .mapToDouble(e -> e.getProperty().getValue()).sum();
            if(doubleStream >= this.constraint1) notificationService.sendPushNotification("Notification to Operator : " +
                    "Excessive Bills paid in the last 5 minutes amounting to a sum greater than " +
                    this.constraint1);
        }
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
        return this.description;
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
