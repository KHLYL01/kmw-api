package com.kmw.api.infrastructure.adapters.notifications;

import com.kmw.api.core.domain.ports.NotificationProvider;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SendGridMailAdapter implements NotificationProvider {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending Email via SendGrid to " + recipient + ": " + message);
    }
}