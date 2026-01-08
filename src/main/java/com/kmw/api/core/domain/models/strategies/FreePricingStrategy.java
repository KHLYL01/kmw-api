package com.kmw.api.core.domain.models.strategies;

import com.kmw.api.core.domain.ports.PricingStrategy;
import org.springframework.stereotype.Component;

@Component("FREE")
public class FreePricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;
    }

}
