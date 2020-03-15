package com.jigglejam.traintrax.muscleGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuscleGroupService {
    @Autowired
    private
    MuscleGroupRepository muscleGroupRepository;

    public MuscleGroup create(MuscleGroup muscleGroup) {
        return muscleGroupRepository.save(muscleGroup);
    }

    public MuscleGroup update(MuscleGroup muscleGroup) {
        return muscleGroupRepository.save(muscleGroup);
    }

    public void delete(Long id) {
        muscleGroupRepository.deleteById(id);
    }

    public List<MuscleGroup> getAll() {
        return muscleGroupRepository.findAll();
    }

    public MuscleGroup getById(Long id) {

        Optional<MuscleGroup> maybeMuscleGroup = muscleGroupRepository.findById(id);
        return maybeMuscleGroup.orElse(null);
    }
}
