package com.learning.demo.training;

import org.openapitools.model.CreateTraining;
import org.openapitools.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class TrainingService {

    private final TrainingRepository repository;

    @Autowired
    public TrainingService(TrainingRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Training> createTraining(CreateTraining createTraining) {
        TrainingEntity training = new TrainingEntity(
                createTraining.getName(),
                LocalDate.parse(createTraining.getDate()),
                createTraining.getRequiredLevel(),
                toEntityTypeFromApiType(createTraining.getType())
        );
        repository.save(training);

        return ResponseEntity.ok(convertEntityToApiType(training));
    }

    public ResponseEntity<Training> getTrainingInfo(String trainingId) {
        return ResponseEntity.ok(convertEntityToApiType(repository.getReferenceById(UUID.fromString(trainingId))));
    }

    public ResponseEntity<List<Training>> getTrainings(String date, Integer subscriptionLevel) {
        var dateFormatted = LocalDate.parse(date);
        var list = repository.getAllTrainingsForDateAndSubscriptionLevel(dateFormatted, subscriptionLevel)
                .stream()
                .map(this::convertEntityToApiType)
                .toList();

        return ResponseEntity.ok(list);
    }

    private Training convertEntityToApiType(TrainingEntity entity) {
        return new Training(
                entity.getId(),
                entity.getName(),
                entity.getDate().toString(),
                toApiTypeFromEntityType(entity.getType()),
                entity.getSubscriptionLevel()
        );
    }

    private Training.TypeEnum toApiTypeFromEntityType(TrainingEntity.TrainingType type) {
        Training.TypeEnum result;

        switch (type) {
            case POOOOWER -> result = Training.TypeEnum.POOOOWER;
            case YOGA -> result = Training.TypeEnum.YOGA;
            case CHILLING -> result = Training.TypeEnum.CHILLING;
            default -> throw new IllegalArgumentException("Type is not existing");
        }

        return result;
    }

    private TrainingEntity.TrainingType toEntityTypeFromApiType(CreateTraining.TypeEnum type) {
        TrainingEntity.TrainingType result;

        switch (type) {
            case POOOOWER -> result = TrainingEntity.TrainingType.POOOOWER;
            case YOGA -> result = TrainingEntity.TrainingType.YOGA;
            case CHILLING -> result = TrainingEntity.TrainingType.CHILLING;
            default -> throw new IllegalArgumentException("Type is not existing");
        }

        return result;
    }
}
