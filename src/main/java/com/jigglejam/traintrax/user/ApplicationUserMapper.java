package com.jigglejam.traintrax.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    public ApplicationUser convertToEntity(ApplicationUserDto dto) {
        return ApplicationUser.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .isEnabled(dto.getIsEnabled())
                .build();
    }

    public ApplicationUserDto convertToDto(ApplicationUser user) {
        return ApplicationUserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .isEnabled(user.getIsEnabled())
                .build();
    }
}
