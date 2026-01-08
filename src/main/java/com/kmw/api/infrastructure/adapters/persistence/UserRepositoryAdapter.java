package com.kmw.api.infrastructure.adapters.persistence;

import com.kmw.api.core.domain.models.User;
import com.kmw.api.core.domain.ports.UserRepositoryPort;
import com.kmw.api.web.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository userRepository;
    private final UserMapper userMapper;

    public UserRepositoryAdapter(JpaUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);

        UserEntity savedEntity = userRepository.save(userEntity);

        return userMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email).map(userMapper::toDomain);
    }
}
