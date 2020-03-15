package com.jigglejam.traintrax.exercise;

import com.jigglejam.traintrax.constants.MovementType;
import com.jigglejam.traintrax.equipment.Equipment;
import com.jigglejam.traintrax.muscleGroup.MuscleGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    private MovementType movementType;
    @OneToOne(cascade = CascadeType.ALL)
    private MuscleGroup muscleGroup;
    @OneToOne(cascade = CascadeType.ALL)
    private Equipment equipment;
}
