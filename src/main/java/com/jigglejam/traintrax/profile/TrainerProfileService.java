package com.jigglejam.traintrax.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerProfileService {
    @Autowired
    private
    TrainerProfileRepository trainerProfileRepository;

    public TrainerProfile create(TrainerProfile trainerProfile) {
        return trainerProfileRepository.save(trainerProfile);
    }

    public TrainerProfile update(TrainerProfile trainerProfile) {
        return trainerProfileRepository.save(trainerProfile);
    }

    public void delete(Long id) {
        trainerProfileRepository.deleteById(id);
    }

    public List<TrainerProfile> getAll() {
        return trainerProfileRepository.findAll();
    }

    public TrainerProfile getById(Long id) {

        Optional<TrainerProfile> maybeTrainerProfile = trainerProfileRepository.findById(id);
        return maybeTrainerProfile.orElse(null);
    }
}