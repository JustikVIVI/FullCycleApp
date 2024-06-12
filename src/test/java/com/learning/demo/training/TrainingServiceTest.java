package com.learning.demo.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.Training;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.learning.demo.Fixture.defaultTrainingEntity1;
import static com.learning.demo.Fixture.defaultTrainingEntity2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrainingServiceTest {

    @Mock
    private TrainingRepository trainingRepository;

    private TrainingService trainingService;

    @BeforeEach
    public void setUp() {
        trainingService = new TrainingService(trainingRepository);
    }

    @Test
    public void testGetTrainings_validDateAndSubscriptionLevel_returnsCorrectList() {
        // Arrange
        String date = "2022-01-01";
        Integer subscriptionLevel = 1;
        List<TrainingEntity> trainingEntities = List.of(defaultTrainingEntity1, defaultTrainingEntity2);

        when(trainingRepository.getAllTrainingsForDateAndSubscriptionLevel(any(), any()))
               .thenReturn(trainingEntities);

        // Act
        ResponseEntity<List<Training>> response = trainingService.getTrainings(date, subscriptionLevel);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        List<Training> trainings = response.getBody();
        assertNotNull(trainings);
        assertEquals(2, trainings.size());

        Training training1 = trainings.get(0);
        assertEquals(defaultTrainingEntity1.getId(), training1.getId());
        assertEquals(defaultTrainingEntity1.getName(), training1.getName());
        assertEquals(defaultTrainingEntity1.getDate().toString(), training1.getDate());

        Training training2 = trainings.get(1);
        assertEquals(defaultTrainingEntity2.getId(), training2.getId());
        assertEquals(defaultTrainingEntity2.getName(), training2.getName());
        assertEquals(defaultTrainingEntity2.getDate().toString(), training2.getDate());
    }

    // Maybe I need to add more test cases for other scenarios...
}