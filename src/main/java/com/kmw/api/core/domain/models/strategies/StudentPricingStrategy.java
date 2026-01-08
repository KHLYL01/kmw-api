package com.kmw.api.core.domain.models.strategies;

import com.kmw.api.core.domain.ports.PricingStrategy;
import org.springframework.stereotype.Component;

@Component("STUDENT")
public class StudentPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.5;
    }
}
