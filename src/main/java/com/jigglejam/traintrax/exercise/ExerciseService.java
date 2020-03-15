package com.jigglejam.traintrax.exercise;

import com.jigglejam.traintrax.exercise.Exercise;
import com.jigglejam.traintrax.exercise.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    @Autowired
    private
    ExerciseRepository exerciseRepository;

    public Exercise create(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Exercise update(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void delete(Long id) {
        exerciseRepository.deleteById(id);
    }

    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

    public Exercise getById(Long id) {

        Optional<Exercise> maybeExercise = exerciseRepository.findById(id);
        return maybeExercise.orElse(null);
    }
}
