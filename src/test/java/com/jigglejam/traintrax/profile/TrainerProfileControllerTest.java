package com.jigglejam.traintrax.profile;

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
public class TrainerProfileControllerTest {

    @Mock
    TrainerProfileService trainerProfileService;

    @InjectMocks
    TrainerProfileController trainerProfileController;

    private List<TrainerProfile> trainerProfiles;
    private long trainerProfileId = 12L;
    private TrainerProfile trainerProfile = TrainerProfile.builder().id(trainerProfileId).build();

    @Before
    public void setup() {
        when(trainerProfileService.getAll()).thenReturn(
                Collections.singletonList(trainerProfile));
        when(trainerProfileService.getById(trainerProfileId)).thenReturn(trainerProfile);
        when(trainerProfileService.create(trainerProfile)).thenReturn(trainerProfile);
        when(trainerProfileService.update(trainerProfile)).thenReturn(trainerProfile);
    }

    @Test
    public void getAllCallsTrainerProfileService() {
        trainerProfiles = trainerProfileController.getAll();
        verify(trainerProfileService, times(1)).getAll();
    }

    @Test
    public void getAllReturnsTrainerProfileServiceResponse() {
        trainerProfiles = trainerProfileController.getAll();
        assertEquals(trainerProfile, trainerProfiles.get(0));
    }

    @Test
    public void getByIdCallsTrainerProfileServiceWithId() {
        trainerProfileController.getById(trainerProfileId);
        verify(trainerProfileService, times(1)).getById(trainerProfileId);
    }

    @Test
    public void getByIdReturnsTrainerProfileFromTrainerProfileService() {
        TrainerProfile response = trainerProfileController.getById(trainerProfileId);
        assertEquals(response, trainerProfile);
    }

    @Test
    public void createCallsTrainerProfileService() {
        trainerProfileController.create(trainerProfile);
        verify(trainerProfileService, times(1)).create(trainerProfile);
    }

    @Test
    public void createReturnsCreatedTrainerProfile() {
        TrainerProfile response = trainerProfileController.create(trainerProfile);
        assertEquals(response, trainerProfile);
    }

    @Test
    public void updateCallsTrainerProfileService() {
        trainerProfileController.update(trainerProfile);
        verify(trainerProfileService, times(1)).update(trainerProfile);
    }

    @Test
    public void updateReturnsUpdatedTrainerProfile() {
        TrainerProfile response = trainerProfileController.update(trainerProfile);
        assertEquals(response, trainerProfile);
    }

    @Test
    public void deleteByIdCallsTrainerProfileService() {
        trainerProfileController.deleteById(trainerProfileId);
        verify(trainerProfileService, times(1)).delete(trainerProfileId);
    }
}