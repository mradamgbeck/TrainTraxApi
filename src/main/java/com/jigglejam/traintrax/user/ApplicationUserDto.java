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
    private String email;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private Boolean isEnabled;
}
