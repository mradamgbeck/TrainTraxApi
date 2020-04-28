package com.jigglejam.traintrax.profile;

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
public class TrainerProfileServiceTest {

    @Mock
    TrainerProfileRepository trainerProfileRepository;

    @InjectMocks
    TrainerProfileService trainerProfileService;
    private long trainerProfileId = 24L;
    private TrainerProfile trainerProfile = TrainerProfile.builder().id(trainerProfileId).build();

    @Before
    public void setup() {
        when(trainerProfileRepository.save(trainerProfile)).thenReturn(trainerProfile);
        when(trainerProfileRepository.findAll()).thenReturn(Arrays.asList(trainerProfile));
        when(trainerProfileRepository.findById(trainerProfileId)).thenReturn(Optional.of(trainerProfile));
    }

    @Test
    public void createSavesTrainerProfileInRepository() {
        trainerProfileService.create(trainerProfile);
        verify(trainerProfileRepository, times(1)).save(trainerProfile);
    }

    @Test
    public void createReturnsSavedTrainerProfile() {
        TrainerProfile response = trainerProfileService.create(trainerProfile);
        assertEquals(response, trainerProfile);
    }

    @Test
    public void updateSavesTrainerProfileInRepository() {
        trainerProfileService.update(trainerProfile);
        verify(trainerProfileRepository, times(1)).save(trainerProfile);
    }

    @Test
    public void updateReturnsSavedTrainerProfile() {
        TrainerProfile response = trainerProfileService.update(trainerProfile);
        assertEquals(response, trainerProfile);
    }

    @Test
    public void deleteRemovesTrainerProfileFromRepository() {
        trainerProfileService.delete(trainerProfileId);
        verify(trainerProfileRepository).deleteById(trainerProfileId);
    }

    @Test
    public void getAllGetsAllFromRepository() {
        trainerProfileService.getAll();
        verify(trainerProfileRepository, times(1)).findAll();
    }

    @Test
    public void getAllReturnsListOfAllTrainerProfiles() {
        List<TrainerProfile> response = trainerProfileService.getAll();
        assertEquals(response.get(0), trainerProfile);
    }

    @Test
    public void getByIdFindsByIdFromRepository() {
        trainerProfileService.getById(trainerProfileId);
        verify(trainerProfileRepository, times(1)).findById(trainerProfileId);
    }

    @Test
    public void getAllReturnsTrainerProfile() {
        TrainerProfile response = trainerProfileService.getById(trainerProfileId);
        assertEquals(response, trainerProfile);
    }

    @Test
    public void getAllReturnsNullIfNoTrainerProfile() {
        when(trainerProfileRepository.findById(trainerProfileId)).thenReturn(Optional.empty());
        TrainerProfile response = trainerProfileService.getById(trainerProfileId);
        assertNull(response);
    }
}