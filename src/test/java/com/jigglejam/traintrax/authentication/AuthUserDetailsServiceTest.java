package com.jigglejam.traintrax.authentication;

import com.jigglejam.traintrax.user.ApplicationUser;
import com.jigglejam.traintrax.user.ApplicationUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthUserDetailsServiceTest {

    private final String email = "dude";
    private final String password = "sweet";
    private final ApplicationUser applicationUser = ApplicationUser.builder()
            .email(email)
            .password(password)
            .build();
    @Mock
    ApplicationUserRepository applicationUserRepository;
    @InjectMocks
    AuthUserDetailsService authUserDetailsService;
    private UserDetails actualUser;

    @Before
    public void setup() {
        when(applicationUserRepository.findByEmail(email)).thenReturn(Optional.of(applicationUser));
        actualUser = authUserDetailsService.loadUserByUsername(email);
    }

    @Test
    public void itFindsTheUserByUsername() {
        verify(applicationUserRepository).findByEmail(email);
    }

    @Test
    public void itReturnsAUserWithTheApplicationUsersCredentials() {
        assertEquals(applicationUser.getEmail(), actualUser.getUsername());
        assertEquals(applicationUser.getPassword(), actualUser.getPassword());
    }
}
