package com.kmw.api.infrastructure.adapters.external;

import com.kmw.api.core.domain.ports.PaymentProcessor;
import com.kmw.api.core.domain.ports.Refundable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StripePaymentAdapter implements PaymentProcessor, Refundable {

    @Override
    public void process(double amount) {
        System.out.println("Processing payment of $" + amount + " via Stripe...");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding $" + amount + " via Stripe...");
    }
}