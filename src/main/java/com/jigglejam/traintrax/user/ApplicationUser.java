package com.jigglejam.traintrax.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public
class ApplicationUser {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String role;
    private Boolean isEnabled;
}
