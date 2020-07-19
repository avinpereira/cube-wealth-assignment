package com.bankoncube.eventsingestor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    public void sendPushNotification(String message){
      log.info(message);   // TODO: Log into a File a push notification
    }
}
