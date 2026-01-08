package com.kmw.api.core.domain.ports;

public interface PaymentProcessor {
    void process(double amount);
}

