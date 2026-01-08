package com.kmw.api.infrastructure.adapters.notifications;

import com.kmw.api.core.domain.ports.NotificationProvider;
import org.springframework.stereotype.Component;

@Component
public class TwilioSmsAdapter implements NotificationProvider {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending SMS via Twilio to " + recipient + ": " + message);
    }
}