package com.learning.demo.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.CreateTraining;
import org.openapitools.model.Training;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrainingControllerTest {

    @Mock
    private TrainingService trainingService;

    private TrainingController trainingController;

    @BeforeEach
    public void setUp() {
        trainingController = new TrainingController(trainingService);
    }

    @Test
    public void getTraining_shouldReturnTrainingById() {
        var training = mock(Training.class);
        var trainingId = UUID.randomUUID().toString();

        when(trainingService.getTrainingInfo(trainingId)).thenReturn(ResponseEntity.ok(training));

        trainingController.getTrainingInfo(trainingId);

        verify(trainingService, Mockito.times(1)).getTrainingInfo(trainingId);
    }

    @Test
    public void getTrainings_shouldReturnListOfTrainings() {
        var training = mock(Training.class);
        var trainingId = UUID.randomUUID().toString();

        when(trainingService.getTrainingInfo(trainingId)).thenReturn(ResponseEntity.ok(training));

        trainingController.getTrainingInfo(trainingId);

        verify(trainingService, Mockito.times(1)).getTrainingInfo(trainingId);
    }

    @Test
    public void createTraining_shouldReturnTraining() {
        var createTraining = mock(CreateTraining.class);
        var training = mock(Training.class);

        when(trainingService.createTraining(createTraining)).thenReturn(ResponseEntity.ok(training));

        trainingController.createTraining(createTraining);

        verify(trainingService, Mockito.times(1)).createTraining(createTraining);
    }
}