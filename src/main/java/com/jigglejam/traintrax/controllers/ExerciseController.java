package com.jigglejam.traintrax.controllers;

import com.jigglejam.traintrax.entities.Exercise;
import com.jigglejam.traintrax.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/v1/exercise")
public class ExerciseController {
    @Autowired
    private
    ExerciseService exerciseService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Exercise> getAllExercises(){
        return exerciseService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Exercise getExerciseById(@PathVariable Long id){
        return exerciseService.getById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Exercise createExercise(@RequestBody Exercise exercise){
        return exerciseService.create(exercise);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Exercise updateExercise(@RequestBody Exercise exercise){
        return exerciseService.update(exercise);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteExerciseById(@PathVariable Long id){
        exerciseService.delete(id);
    }
}