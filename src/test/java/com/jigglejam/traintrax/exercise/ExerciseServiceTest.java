package com.jigglejam.traintrax.exercise;

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
public class ExerciseServiceTest {

    @Mock
    ExerciseRepository exerciseRepository;

    @InjectMocks
    ExerciseService exerciseService;
    private long exerciseId = 24L;
    private Exercise exercise = Exercise.builder().id(exerciseId).build();

    @Before
    public void setup() {
        when(exerciseRepository.save(exercise)).thenReturn(exercise);
        when(exerciseRepository.findAll()).thenReturn(Arrays.asList(exercise));
        when(exerciseRepository.findById(exerciseId)).thenReturn(Optional.of(exercise));
    }

    @Test
    public void createSavesExerciseInRepository() {
        exerciseService.create(exercise);
        verify(exerciseRepository, times(1)).save(exercise);
    }

    @Test
    public void createReturnsSavedExercise() {
        Exercise response = exerciseService.create(this.exercise);
        assertEquals(response, exercise);
    }

    @Test
    public void updateSavesExerciseInRepository() {
        exerciseService.update(exercise);
        verify(exerciseRepository, times(1)).save(exercise);
    }

    @Test
    public void updateReturnsSavedExercise() {
        Exercise response = exerciseService.update(this.exercise);
        assertEquals(response, exercise);
    }

    @Test
    public void deleteRemovesExerciseFromRepository() {
        exerciseService.delete(exerciseId);
        verify(exerciseRepository).deleteById(exerciseId);
    }

    @Test
    public void getAllGetsAllFromRepository() {
        exerciseService.getAll();
        verify(exerciseRepository, times(1)).findAll();
    }

    @Test
    public void getAllReturnsListOfAllExercises() {
        List<Exercise> response = exerciseService.getAll();
        assertEquals(response.get(0), exercise);
    }

    @Test
    public void getByIdFindsByIdFromRepository() {
        exerciseService.getById(exerciseId);
        verify(exerciseRepository, times(1)).findById(exerciseId);
    }

    @Test
    public void getAllReturnsExercise() {
        Exercise response = exerciseService.getById(exerciseId);
        assertEquals(response, exercise);
    }

    @Test
    public void getAllReturnsNullIfNoExercise(){
        when(exerciseRepository.findById(exerciseId)).thenReturn(Optional.empty());
        Exercise response = exerciseService.getById(exerciseId);
        assertNull(response);
    }
}
