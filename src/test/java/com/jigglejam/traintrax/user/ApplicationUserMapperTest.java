package com.jigglejam.traintrax.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationUserMapperTest {

    private final String username = "dude";
    private final String password = "sweet";
    private final String role = "d20";
    private final boolean isEnabled = true;
    private final long id = 1L;
    private final ApplicationUser applicationUser = ApplicationUser.builder()
            .username(username)
            .role(role)
            .isEnabled(isEnabled)
            .id(id)
            .build();
    private final ApplicationUserDto applicationUserDto = ApplicationUserDto.builder()
            .username(username)
            .password(password)
            .role(role)
            .isEnabled(isEnabled)
            .id(id)
            .build();
    private final String encodedPassword = "gobbledygook";
    @Mock
    BCryptPasswordEncoder passwordEncoder;
    @InjectMocks
    private
    ApplicationUserMapper applicationUserMapper;

    @Before
    public void setup() {
        when(passwordEncoder.encode(password)).thenReturn(encodedPassword);
    }

    @Test
    public void convertsToDto() {
        ApplicationUserDto response = applicationUserMapper.convertToDto(applicationUser);
        assertEquals(applicationUser.getId(), response.getId());
        assertEquals(applicationUser.getUsername(), response.getUsername());
        assertEquals(applicationUser.getIsEnabled(), response.getIsEnabled());
        assertEquals(applicationUser.getRole(), response.getRole());
        assertNull(response.getPassword());
    }

    @Test
    public void convertsToEntity() {
        ApplicationUser response = applicationUserMapper.convertToEntity(applicationUserDto);
        assertEquals(applicationUserDto.getUsername(), response.getUsername());
        assertEquals(applicationUserDto.getId(), response.getId());
        assertEquals(applicationUserDto.getIsEnabled(), response.getIsEnabled());
        assertEquals(applicationUserDto.getRole(), response.getRole());
        assertEquals(encodedPassword, response.getPassword());
    }
}