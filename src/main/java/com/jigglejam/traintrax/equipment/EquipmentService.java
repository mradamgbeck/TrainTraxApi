package com.jigglejam.traintrax.equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    @Autowired
    private
    EquipmentRepository equipmentRepository;

    public Equipment create(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public Equipment update(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }

    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }

    public Equipment getById(Long id) {
        Optional<Equipment> maybeEquipment = equipmentRepository.findById(id);
        return maybeEquipment.orElse(null);
    }
}
