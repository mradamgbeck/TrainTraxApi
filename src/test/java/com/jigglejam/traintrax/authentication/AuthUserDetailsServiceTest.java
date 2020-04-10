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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthUserDetailsServiceTest {

    private final String username = "dude";
    private final String password = "sweet";
    private final ApplicationUser applicationUser = ApplicationUser.builder()
            .username(username)
            .password(password)
            .build();
    @Mock
    ApplicationUserRepository applicationUserRepository;
    @InjectMocks
    AuthUserDetailsService authUserDetailsService;
    private UserDetails actualUser;

    @Before
    public void setup() {
        when(applicationUserRepository.findByUsername(username)).thenReturn(applicationUser);
        actualUser = authUserDetailsService.loadUserByUsername(username);
    }

    @Test
    public void itFindsTheUserByUsername() {
        verify(applicationUserRepository).findByUsername(username);
    }

    @Test
    public void itReturnsAUserWithTheApplicationUsersCredentials() {
        assertEquals(applicationUser.getUsername(), actualUser.getUsername());
        assertEquals(applicationUser.getPassword(), actualUser.getPassword());
    }
}
