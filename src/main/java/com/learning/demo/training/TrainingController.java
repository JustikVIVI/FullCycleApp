package com.learning.demo.training;

import org.openapitools.api.TrainingsApi;
import org.openapitools.model.CreateTraining;
import org.openapitools.model.Training;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class TrainingController implements TrainingsApi {

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
