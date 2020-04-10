package com.jigglejam.traintrax.exercise;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private MovementType movementType;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<MuscleGroup> exerciseMuscleGroups;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Equipment> exerciseEquipment;
}
