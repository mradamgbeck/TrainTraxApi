package com.jigglejam.traintrax.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jigglejam.traintrax.user.ApplicationUserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JWTAuthenticationFilterTest {
    private final String username = "dude";
    private final String password = "sweet";
    private final UsernamePasswordAuthenticationToken expectedToken = new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
    private JWTAuthenticationFilter jwtAuthenticationFilter;
    private ObjectMapper objectMapper = Mockito.mock(ObjectMapper.class);
    private AuthenticationManager authenticationManager = Mockito.mock(AuthenticationManager.class);
    private ApplicationUserDto userDto = ApplicationUserDto.builder()
            .email(username)
            .password(password).build();
    private HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);

    @Before
    public void setup() throws IOException {
        when(objectMapper.readValue(any(ServletInputStream.class), eq(ApplicationUserDto.class))).thenReturn(userDto);
        when(authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>()))).thenReturn(expectedToken);
        jwtAuthenticationFilter = new JWTAuthenticationFilter(objectMapper, authenticationManager);
        mockRequest = new MockHttpServletRequest();
    }

    @Test
    public void itReturnsAnAuthenticationWhenAttempted() {
        Authentication authentication = jwtAuthenticationFilter.attemptAuthentication(mockRequest, new MockHttpServletResponse());
        assertEquals(authentication.getPrincipal(), userDto.getEmail());
        assertEquals(authentication.getCredentials(), userDto.getPassword());
        assertTrue(authentication.isAuthenticated());
    }
}
