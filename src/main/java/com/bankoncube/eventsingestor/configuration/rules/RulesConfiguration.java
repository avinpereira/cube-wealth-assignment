package com.bankoncube.eventsingestor.configuration.rules;

import com.bankoncube.eventsingestor.entity.Customer;
import com.bankoncube.eventsingestor.entity.Event;
import com.bankoncube.eventsingestor.rule_framework.Rule;
import com.bankoncube.eventsingestor.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class RulesConfiguration {

    @Bean
    Rule notificationRule(){
        Rule notificationRule = new Rule() {
            @Autowired
            NotificationService notificationService;
            @Override
            public void implementRule(Customer customer) {
                if(customer.getEvents().isEmpty() || customer.getEvents().size() <= super.getConstraint1()) notificationService.sendPushNotification("Congrats on your first Event");
            }
        };
        notificationRule.setConstraint1(1);
        notificationRule.setConstraint2(null);
        notificationRule.setDescription("Trigger a push notification on every {constraint1} bill pay event for the user");
        return notificationRule;
    }



    @Bean
    Rule excessivePayEventRule(){
        Rule excessivePayEventRule = new Rule() {

            @Autowired
            NotificationService notificationService;

            @Override
            public void implementRule(Customer customer) {
                List<Event> eventList = customer.getEvents().stream()
                        .filter(e -> "pay".equals(e.getVerb()))
                        .filter(e -> Instant.now().minus(super.getConstraint2(), ChronoUnit.MINUTES).isBefore(e.getSourceTimestamp()))
                        .collect(Collectors.toList());
                if(eventList.size() >= 5) {
                    double doubleStream = eventList.stream()
                            .mapToDouble(e -> e.getProperty().getValue()).sum();
                    if(doubleStream >= super.getConstraint1()) notificationService.sendPushNotification("Notification to Operator : " +
                            "Excessive Bills paid in the last 5 minutes amounting to a sum greater than " +
                            super.getConstraint1());
                }
            }
        };
        excessivePayEventRule.setDescription("Alert user if 5 or more bill pay events of total value >= {constraint1} happen within {constraint2} minutes time window");
        excessivePayEventRule.setConstraint1(20000);
        excessivePayEventRule.setConstraint2(5);
        return excessivePayEventRule;
    }
}
