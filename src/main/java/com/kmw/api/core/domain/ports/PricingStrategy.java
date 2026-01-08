package com.kmw.api.core.domain.ports;

public interface PricingStrategy {
    double calculatePrice(double basePrice);
}
