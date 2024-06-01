package com.learning.demo.training;

import org.openapitools.api.TrainingsApi;
import org.openapitools.model.CreateTraining;
import org.openapitools.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class TrainingController implements TrainingsApi {

    private final TrainingService service;

    @Autowired
    public TrainingController(TrainingService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Training> createTraining(CreateTraining createTraining) {
        return service.createTraining(createTraining);
    }

    @Override
    public ResponseEntity<Training> getTrainingInfo(String trainingId) {
        return service.getTrainingInfo(trainingId);
    }

    @Override
    public ResponseEntity<List<Training>> getTrainings(String date, Integer subscriptionLevel) {
        return service.getTrainings(date, subscriptionLevel);
    }
}
