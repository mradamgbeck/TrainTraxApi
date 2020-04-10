package com.jigglejam.traintrax.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    ApplicationUserService applicationUserService;

    @InjectMocks
    ApplicationUserController applicationUserController;

    private List<ApplicationUser> applicationUsers;
    private long applicationUserId = 12L;
    private ApplicationUserDto applicationUser = ApplicationUserDto.builder().id(applicationUserId).build();

    @Before
    public void setup() {
        when(applicationUserService.getAll()).thenReturn(
                Collections.singletonList(applicationUser));
        when(applicationUserService.getById(applicationUserId)).thenReturn(applicationUser);
        when(applicationUserService.create(applicationUser)).thenReturn(applicationUser.getId());
    }

    @Test
    public void getAllCallsApplicationUserService() {
        applicationUserController.getAll();
        verify(applicationUserService, times(1)).getAll();
    }

    @Test
    public void getAllReturnsApplicationUserServiceResponse() {
        List<ApplicationUserDto> body = applicationUserController.getAll();
        assertEquals(applicationUser, body.get(0));
    }

    @Test
    public void getByIdCallsApplicationUserServiceWithId() {
        applicationUserController.getById(applicationUserId);
        verify(applicationUserService, times(1)).getById(applicationUserId);
    }

    @Test
    public void getByIdReturnsApplicationUserFromApplicationUserService() {
        ApplicationUserDto response = applicationUserController.getById(applicationUserId);
        assertEquals(applicationUser, response);
    }

    @Test
    public void createCallsApplicationUserService() {
        applicationUserController.create(applicationUser);
        verify(applicationUserService, times(1)).create(applicationUser);
    }

    @Test
    public void createReturnsCreatedApplicationUser() {
        Long response = applicationUserController.create(applicationUser);
        assertEquals(applicationUser.getId(), response);
    }
}