package com.jigglejam.traintrax.equipment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jigglejam.traintrax.exercise.Exercise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties("exercises")
public class Equipment {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "equipment")
    private Set<Exercise> exercises;
}
