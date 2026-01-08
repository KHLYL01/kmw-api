package com.kmw.api.web.mapper;

import com.kmw.api.core.domain.models.User;
import com.kmw.api.infrastructure.adapters.persistence.UserEntity;
import com.kmw.api.web.dto.UserRegistrationRequest;
import com.kmw.api.web.dto.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toDomain(UserRegistrationRequest request);

    UserEntity toEntity(User user);

    User toDomain(UserEntity entity);

    UserResponseDto toResponseDto(User user);
}
