package com.jigglejam.traintrax.equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Equipment> getAll() {
        return equipmentService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Equipment getById(@PathVariable Long id) {
        return equipmentService.getById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Equipment create(@RequestBody Equipment equipment) {
        return equipmentService.create(equipment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Equipment update(@RequestBody Equipment equipment) {
        return equipmentService.update(equipment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        equipmentService.delete(id);
    }
}
