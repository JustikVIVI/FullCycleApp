package com.learning.demo.training;

import com.learning.demo.training.repository.TrainingRepository;
import org.openapitools.api.TrainingsApi;
import org.openapitools.model.CreateTraining;
import org.openapitools.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class TrainingController implements TrainingsApi {

    private TrainingRepository trainingRepository;

    @Autowired
    public TrainingController(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public ResponseEntity<Training> createTraining(CreateTraining createTraining) {
        return TrainingsApi.super.createTraining(createTraining);
    }

    @Override
    public ResponseEntity<Training> getTrainingInfo(String trainingId) {
        return TrainingsApi.super.getTrainingInfo(trainingId);
    }

    @Override
    public ResponseEntity<Training> getTrainings(String date, BigDecimal subscriptionLevel) {
        return TrainingsApi.super.getTrainings(date, subscriptionLevel);
    }
}
