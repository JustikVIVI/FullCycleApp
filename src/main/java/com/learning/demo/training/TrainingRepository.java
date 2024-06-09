package com.learning.demo.training;

import org.openapitools.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface TrainingRepository extends JpaRepository<TrainingEntity, String> {

    @Query(
       value = "SELECT * FROM trainings WHERE subscription_level <= :subscriptionLevel AND date = :date",
       nativeQuery = true
    )
    List<TrainingEntity> getAllTrainingsForDateAndSubscriptionLevel(LocalDate date, Integer subscriptionLevel);
}
