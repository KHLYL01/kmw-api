package com.kmw.api.core.domain.ports;

public interface NotificationProvider {
    void sendNotification(String recipient, String message);
}