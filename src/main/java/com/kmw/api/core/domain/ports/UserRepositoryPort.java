package com.kmw.api.core.domain.ports;

import com.kmw.api.core.domain.models.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findByEmail(String email);
}
