package com.jigglejam.traintrax.muscleGroup;

import com.jigglejam.traintrax.muscleGroup.MuscleGroup;
import com.jigglejam.traintrax.muscleGroup.MuscleGroupRepository;
import com.jigglejam.traintrax.muscleGroup.MuscleGroupService;
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
public class MuscleGroupServiceTest {

    @Mock
    MuscleGroupRepository muscleGroupRepository;

    @InjectMocks
    MuscleGroupService muscleGroupService;
    private long muscleGroupId = 24L;
    private MuscleGroup muscleGroup = MuscleGroup.builder().id(muscleGroupId).build();

    @Before
    public void setup() {
        when(muscleGroupRepository.save(muscleGroup)).thenReturn(muscleGroup);
        when(muscleGroupRepository.findAll()).thenReturn(Arrays.asList(muscleGroup));
        when(muscleGroupRepository.findById(muscleGroupId)).thenReturn(Optional.of(muscleGroup));
    }

    @Test
    public void createSavesMuscleGroupInRepository() {
        muscleGroupService.create(muscleGroup);
        verify(muscleGroupRepository, times(1)).save(muscleGroup);
    }

    @Test
    public void createReturnsSavedMuscleGroup() {
        MuscleGroup response = muscleGroupService.create(this.muscleGroup);
        assertEquals(response, muscleGroup);
    }

    @Test
    public void updateSavesMuscleGroupInRepository() {
        muscleGroupService.update(muscleGroup);
        verify(muscleGroupRepository, times(1)).save(muscleGroup);
    }

    @Test
    public void updateReturnsSavedMuscleGroup() {
        MuscleGroup response = muscleGroupService.update(this.muscleGroup);
        assertEquals(response, muscleGroup);
    }

    @Test
    public void deleteRemovesMuscleGroupFromRepository() {
        muscleGroupService.delete(muscleGroupId);
        verify(muscleGroupRepository).deleteById(muscleGroupId);
    }

    @Test
    public void getAllGetsAllFromRepository() {
        muscleGroupService.getAll();
        verify(muscleGroupRepository, times(1)).findAll();
    }

    @Test
    public void getAllReturnsListOfAllMuscleGroups() {
        List<MuscleGroup> response = muscleGroupService.getAll();
        assertEquals(response.get(0), muscleGroup);
    }

    @Test
    public void getByIdFindsByIdFromRepository() {
        muscleGroupService.getById(muscleGroupId);
        verify(muscleGroupRepository, times(1)).findById(muscleGroupId);
    }

    @Test
    public void getAllReturnsMuscleGroup() {
        MuscleGroup response = muscleGroupService.getById(muscleGroupId);
        assertEquals(response, muscleGroup);
    }

    @Test
    public void getAllReturnsNullIfNoMuscleGroup(){
        when(muscleGroupRepository.findById(muscleGroupId)).thenReturn(Optional.empty());
        MuscleGroup response = muscleGroupService.getById(muscleGroupId);
        assertNull(response);
    }
}
