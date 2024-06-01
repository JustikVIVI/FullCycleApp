package com.learning.demo.training;

import org.openapitools.model.CreateTraining;
import org.openapitools.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TrainingService {

    private TrainingRepository repository;

    @Autowired
    public TrainingService(TrainingRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Training> createTraining(CreateTraining createTraining) {
        return null; // TODO
    }

    public ResponseEntity<Training> getTrainingInfo(String trainingId) {
        return ResponseEntity.ok(from(repository.getReferenceById(trainingId)));
    }

    public ResponseEntity<List<Training>> getTrainings(String date, Integer subscriptionLevel) {
        return null; // TODO:
    }

    private Training from(TrainingEntity entity) {
        return new Training(
                UUID.fromString(entity.getId()),
                entity.getName(),
                from(entity.getTrainingType()),
                entity.getSubscriptionLevel()
        );
    }

    private Training.TypeEnum from(TrainingEntity.TrainingType type) {
        Training.TypeEnum result;

        switch (type) {
            case POOOOWER -> result = Training.TypeEnum.POOOOWER;
            case YOGA -> result = Training.TypeEnum.YOGA;
            case CHILLING -> result = Training.TypeEnum.CHILLING;
            default -> throw new IllegalArgumentException("Type is not existing");
        }

        return result;
    }
}
