package com.bankoncube.eventsingestor.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendPushNotification(String message){
        System.out.println(message); // TODO: Log into a File a push notification
    }
}
