package com.kmw.api.web.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;

    private String username;

    private String email;

    private String password;

    private String subscriptionType; // "STUDENT", "PREMIUM", "FREE"
}