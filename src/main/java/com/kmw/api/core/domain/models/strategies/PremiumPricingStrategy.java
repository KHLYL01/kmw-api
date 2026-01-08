package com.kmw.api.core.domain.models.strategies;

import com.kmw.api.core.domain.ports.PricingStrategy;
import org.springframework.stereotype.Component;

@Component("PREMIUM")
public class PremiumPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.9;
    }
}
