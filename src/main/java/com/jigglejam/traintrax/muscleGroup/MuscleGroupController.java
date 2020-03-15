package com.jigglejam.traintrax.muscleGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/muscle-group")
public class MuscleGroupController {

    @Autowired
    private MuscleGroupService muscleGroupService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<MuscleGroup> getAll() {
        return muscleGroupService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MuscleGroup getById(@PathVariable Long id) {
        return muscleGroupService.getById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public MuscleGroup create(@RequestBody MuscleGroup muscleGroup) {
        return muscleGroupService.create(muscleGroup);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public MuscleGroup update(@RequestBody MuscleGroup muscleGroup) {
        return muscleGroupService.update(muscleGroup);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        muscleGroupService.delete(id);
    }
}
