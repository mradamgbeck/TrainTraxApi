package com.jigglejam.traintrax.exercise;

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
    public List<Exercise> getAllExercises() {
        List<Exercise> all = exerciseService.getAll();
        return all;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Exercise getById(@PathVariable Long id) {
        return exerciseService.getById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Exercise create(@RequestBody Exercise exercise) {
        return exerciseService.create(exercise);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Exercise update(@RequestBody Exercise exercise) {
        return exerciseService.update(exercise);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        exerciseService.delete(id);
    }
}
