package com.jigglejam.traintrax.exercise;

import com.jigglejam.traintrax.constants.MovementType;
import com.jigglejam.traintrax.constants.MuscleGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private MuscleGroup muscleGroup;
    private MovementType movementType;
}
