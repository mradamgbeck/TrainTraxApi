package com.jigglejam.traintrax.profile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/trainerProfile")
public class TrainerProfileController {

    @Autowired
    private TrainerProfileService trainerProfileService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TrainerProfile> getAll() {
        return trainerProfileService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TrainerProfile getById(@PathVariable Long id) {
        return trainerProfileService.getById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TrainerProfile create(@RequestBody TrainerProfile trainerProfile) {
        return trainerProfileService.create(trainerProfile);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public TrainerProfile update(@RequestBody TrainerProfile trainerProfile) {
        return trainerProfileService.update(trainerProfile);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        trainerProfileService.delete(id);
    }
}
