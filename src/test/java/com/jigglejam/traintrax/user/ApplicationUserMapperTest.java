package com.jigglejam.traintrax.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationUserMapperTest {

    private final String email = "dude@bro.gov";
    private final String password = "5w33T!";
    private final String role = "d20";
    private final boolean isEnabled = true;
    private final long id = 1L;
    private final String firstName = "His Dudeness";
    private final String lastName = "Sweetarino";
    private final ApplicationUser applicationUser = ApplicationUser.builder()
            .email(email)
            .role(role)
            .firstName(firstName)
            .lastName(lastName)
            .isEnabled(isEnabled)
            .id(id)
            .build();
    private final ApplicationUserDto applicationUserDto = ApplicationUserDto.builder()
            .email(email)
            .password(password)
            .role(role)
            .firstName(firstName)
            .lastName(lastName)
            .isEnabled(isEnabled)
            .id(id)
            .build();
    private final String encodedPassword = "gobbledygook";
    @Mock
    PasswordEncoder passwordEncoder;
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
        assertEquals(applicationUser.getEmail(), response.getEmail());
        assertEquals(applicationUser.getIsEnabled(), response.getIsEnabled());
        assertEquals(applicationUser.getRole(), response.getRole());
        assertEquals(applicationUser.getFirstName(), response.getFirstName());
        assertEquals(applicationUser.getLastName(), response.getLastName());
        assertNull(response.getPassword());
    }

    @Test
    public void convertsToEntity() {
        ApplicationUser response = applicationUserMapper.convertToEntity(applicationUserDto);
        assertEquals(applicationUserDto.getEmail(), response.getEmail());
        assertEquals(applicationUserDto.getId(), response.getId());
        assertEquals(applicationUserDto.getIsEnabled(), response.getIsEnabled());
        assertEquals(applicationUserDto.getRole(), response.getRole());
        assertEquals(applicationUserDto.getFirstName(), response.getFirstName());
        assertEquals(applicationUserDto.getLastName(), response.getLastName());
        assertEquals(encodedPassword, response.getPassword());
    }
}