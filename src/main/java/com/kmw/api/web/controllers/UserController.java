package com.kmw.api.web.controllers;

import com.kmw.api.core.usecases.RegisterUserUseCase;
import com.kmw.api.core.domain.models.User;
import com.kmw.api.infrastructure.adapters.external.StripePaymentAdapter;
import com.kmw.api.web.dto.UserRegistrationRequest;
import com.kmw.api.web.dto.UserResponseDto;
import com.kmw.api.web.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final UserMapper userMapper;

    public UserController(RegisterUserUseCase registerUserUseCase, UserMapper userMapper, StripePaymentAdapter stripePaymentAdapter) {
        this.registerUserUseCase = registerUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody UserRegistrationRequest request) {
        User userDomain = userMapper.toDomain(request);

        User savedUser = registerUserUseCase.execute(userDomain);

        return ResponseEntity.ok(userMapper.toResponseDto(savedUser));
    }
}