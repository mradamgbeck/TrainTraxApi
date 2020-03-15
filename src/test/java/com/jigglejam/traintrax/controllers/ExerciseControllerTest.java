package com.jigglejam.traintrax.controllers;

import com.jigglejam.traintrax.entities.Exercise;
import com.jigglejam.traintrax.services.ExerciseService;
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
public class ExerciseControllerTest {

    @Mock
    ExerciseService exerciseService;

    @InjectMocks
    ExerciseController exerciseController;

    private List<Exercise> exercises;
    private long exerciseId = 12L;
    private Exercise exercise = Exercise.builder().id(exerciseId).build();

    @Before
    public void setup() {
        when(exerciseService.getAll()).thenReturn(
                Collections.singletonList(exercise));
        when(exerciseService.getById(exerciseId)).thenReturn(exercise);
        when(exerciseService.create(exercise)).thenReturn(exercise);
        when(exerciseService.update(exercise)).thenReturn(exercise);
    }

    @Test
    public void getAllCallsExerciseService() {
        exercises = exerciseController.getAllExercises();
        verify(exerciseService, times(1)).getAll();
    }

    @Test
    public void getAllReturnsExerciseServiceResponse() {
        exercises = exerciseController.getAllExercises();
        assertEquals(exercise, exercises.get(0));
    }

    @Test
    public void getByIdCallsExerciseServiceWithId() {
        exerciseController.getById(exerciseId);
        verify(exerciseService, times(1)).getById(exerciseId);
    }

    @Test
    public void getByIdReturnsExerciseFromExerciseService() {
        Exercise response = exerciseController.getById(exerciseId);
        assertEquals(response, exercise);
    }

    @Test
    public void createCallsExerciseService() {
        exerciseController.create(exercise);
        verify(exerciseService, times(1)).create(exercise);
    }

    @Test
    public void createReturnsCreatedExercise() {
        Exercise response = exerciseController.create(this.exercise);
        assertEquals(response, exercise);
    }

    @Test
    public void updateCallsExerciseService() {
        exerciseController.update(exercise);
        verify(exerciseService, times(1)).update(exercise);
    }

    @Test
    public void updateReturnsUpdatedExercise() {
        Exercise response = exerciseController.update(this.exercise);
        assertEquals(response, exercise);
    }

    @Test
    public void deleteByIdCallsExerciseService() {
        exerciseController.deleteById(exerciseId);
        verify(exerciseService, times(1)).delete(exerciseId);
    }
}
