package com.jigglejam.traintrax.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationUserDto {
    private Long id;
    private String username;
    private String password;
    private String role;
    private Boolean isEnabled;
}
