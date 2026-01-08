package com.kmw.api.core.usecases;

import com.kmw.api.core.domain.models.User;
import com.kmw.api.core.domain.ports.NotificationProvider;
import com.kmw.api.core.domain.ports.PaymentProcessor;
import com.kmw.api.core.domain.ports.PricingStrategy;
import com.kmw.api.core.domain.ports.UserRepositoryPort;
import com.kmw.api.infrastructure.adapters.external.StripePaymentAdapter;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RegisterUserUseCase {

    private final UserRepositoryPort userRepository;
    private final Map<String, PricingStrategy> pricingStrategies;
    private final PaymentProcessor paymentProcessor;
    private final NotificationProvider notificationProvider;

    public RegisterUserUseCase(UserRepositoryPort userRepository, Map<String, PricingStrategy> pricingStrategies, StripePaymentAdapter stripePaymentAdapter, PaymentProcessor paymentProcessor, NotificationProvider notificationProvider) {
        this.userRepository = userRepository;
        this.pricingStrategies = pricingStrategies;
        this.paymentProcessor = paymentProcessor;
        this.notificationProvider = notificationProvider;
    }

    public User execute(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        user.activate();

        double basePrice = 100.0;
        PricingStrategy strategy = pricingStrategies.getOrDefault(user.getSubscriptionType(), p -> p);
        double finalPrice = strategy.calculatePrice(basePrice);

        paymentProcessor.process(finalPrice);

        User savedUser = userRepository.save(user);

        notificationProvider.sendNotification(savedUser.getEmail(), "Welcome to SubSecure! Your plan: " + user.getSubscriptionType());

        return savedUser;
    }

}
