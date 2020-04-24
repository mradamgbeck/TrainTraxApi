package com.jigglejam.traintrax.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationUserServiceTest {
    private final String username = "Dude";
    @Mock
    ApplicationUserRepository applicationUserRepository;
    @Mock
    ApplicationUserMapper applicationUserMapper;
    @InjectMocks
    ApplicationUserService applicationUserService;
    private long applicationUserId = 24L;
    private ApplicationUser applicationUser = ApplicationUser.builder().id(applicationUserId).username(username).build();
    private ApplicationUserDto applicationUserDto = ApplicationUserDto.builder().id(applicationUserId).build();

    @Before
    public void setup() {
        when(applicationUserMapper.convertToDto(applicationUser)).thenReturn(applicationUserDto);
        when(applicationUserMapper.convertToEntity(applicationUserDto)).thenReturn(applicationUser);
        when(applicationUserRepository.save(applicationUser)).thenReturn(applicationUser);
        when(applicationUserRepository.findAll()).thenReturn(Arrays.asList(applicationUser));
        when(applicationUserRepository.findById(applicationUserId)).thenReturn(Optional.of(applicationUser));
        when(applicationUserRepository.findByUsername(username)).thenReturn(Optional.of(applicationUser));
    }

    @Test
    public void createSavesApplicationUserInRepository() {
        applicationUserService.create(applicationUserDto);
        verify(applicationUserRepository, times(1)).save(applicationUser);
    }

    @Test
    public void createReturnsSavedApplicationUser() {
        Long response = applicationUserService.create(applicationUserDto);
        assertEquals(applicationUser.getId(), response);
    }

    @Test
    public void getAllGetsAllFromRepository() {
        applicationUserService.getAll();
        verify(applicationUserRepository, times(1)).findAll();
    }

    @Test
    public void getAllReturnsListOfAllApplicationUsers() {
        List<ApplicationUserDto> response = applicationUserService.getAll();
        assertEquals(response.get(0), applicationUserDto);
    }

    @Test
    public void getByIdFindsByIdFromRepository() {
        applicationUserService.getById(applicationUserId);
        verify(applicationUserRepository, times(1)).findById(applicationUserId);
    }

    @Test
    public void getByIdReturnsApplicationUser() {
        ApplicationUserDto response = applicationUserService.getById(applicationUserId);
        assertEquals(applicationUserDto, response);
    }

    @Test
    public void getByUsernameReturnsApplicationUser() {
        ApplicationUserDto response = applicationUserService.getByUsername(username);
        assertEquals(applicationUserDto, response);
    }

    @Test
    public void getAllReturnsNullIfNoApplicationUser() {
        when(applicationUserRepository.findById(applicationUserId)).thenReturn(Optional.empty());
        ApplicationUserDto response = applicationUserService.getById(applicationUserId);
        assertNull(response);
    }
}