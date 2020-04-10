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
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .isEnabled(dto.getIsEnabled())
                .build();
    }

    public ApplicationUserDto convertToDto(ApplicationUser user) {
        return ApplicationUserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole())
                .isEnabled(user.getIsEnabled())
                .build();
    }
}
