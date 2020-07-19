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


    @Autowired
    public ExcessivePayEventRule(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void implementRule(Event event, Customer customer) {
        List<Event> eventList = customer.getEvents().stream()
                .filter(e -> "pay".equals(e.getVerb()))
                .filter(e -> Instant.now().minus(5, ChronoUnit.MINUTES).isBefore(e.getSourceTimestamp()))
                .collect(Collectors.toList());
        if(eventList.size() >= 5) {
            double doubleStream = eventList.stream()
                    .mapToDouble(e -> e.getProperty().getValue()).sum();
            if(doubleStream >= 20000) notificationService.sendPushNotification("5 Bills paid in the last 5 minutes amounting to a sum greater than 20000");
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
}
