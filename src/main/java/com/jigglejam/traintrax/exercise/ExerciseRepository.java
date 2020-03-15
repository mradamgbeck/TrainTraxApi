package com.jigglejam.traintrax.exercise;

import com.jigglejam.traintrax.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
