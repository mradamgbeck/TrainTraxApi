package com.jigglejam.traintrax.exercise;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jigglejam.traintrax.constants.MovementType;
import com.jigglejam.traintrax.equipment.Equipment;
import com.jigglejam.traintrax.muscleGroup.MuscleGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({"muscleGroups", "equipment"})
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private MovementType movementType;
    @ManyToMany(cascade = CascadeType.REFRESH)
    private Set<MuscleGroup> muscleGroups;
    @ManyToMany(cascade = CascadeType.REFRESH)
    private Set<Equipment> equipment;
}
