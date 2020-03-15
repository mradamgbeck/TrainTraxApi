package com.jigglejam.traintrax.muscleGroup;

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
public class MuscleGroupControllerTest {

    @Mock
    MuscleGroupService muscleGroupService;

    @InjectMocks
    MuscleGroupController muscleGroupController;

    private List<MuscleGroup> muscleGroups;
    private long muscleGroupId = 12L;
    private MuscleGroup muscleGroup = MuscleGroup.builder().id(muscleGroupId).build();

    @Before
    public void setup() {
        when(muscleGroupService.getAll()).thenReturn(
                Collections.singletonList(muscleGroup));
        when(muscleGroupService.getById(muscleGroupId)).thenReturn(muscleGroup);
        when(muscleGroupService.create(muscleGroup)).thenReturn(muscleGroup);
        when(muscleGroupService.update(muscleGroup)).thenReturn(muscleGroup);
    }

    @Test
    public void getAllCallsMuscleGroupService() {
        muscleGroups = muscleGroupController.getAll();
        verify(muscleGroupService, times(1)).getAll();
    }

    @Test
    public void getAllReturnsMuscleGroupServiceResponse() {
        muscleGroups = muscleGroupController.getAll();
        assertEquals(muscleGroup, muscleGroups.get(0));
    }

    @Test
    public void getByIdCallsMuscleGroupServiceWithId() {
        muscleGroupController.getById(muscleGroupId);
        verify(muscleGroupService, times(1)).getById(muscleGroupId);
    }

    @Test
    public void getByIdReturnsMuscleGroupFromMuscleGroupService() {
        MuscleGroup response = muscleGroupController.getById(muscleGroupId);
        assertEquals(response, muscleGroup);
    }

    @Test
    public void createCallsMuscleGroupService() {
        muscleGroupController.create(muscleGroup);
        verify(muscleGroupService, times(1)).create(muscleGroup);
    }

    @Test
    public void createReturnsCreatedMuscleGroup() {
        MuscleGroup response = muscleGroupController.create(this.muscleGroup);
        assertEquals(response, muscleGroup);
    }

    @Test
    public void updateCallsMuscleGroupService() {
        muscleGroupController.update(muscleGroup);
        verify(muscleGroupService, times(1)).update(muscleGroup);
    }

    @Test
    public void updateReturnsUpdatedMuscleGroup() {
        MuscleGroup response = muscleGroupController.update(this.muscleGroup);
        assertEquals(response, muscleGroup);
    }

    @Test
    public void deleteByIdCallsMuscleGroupService() {
        muscleGroupController.deleteById(muscleGroupId);
        verify(muscleGroupService, times(1)).delete(muscleGroupId);
    }
}
