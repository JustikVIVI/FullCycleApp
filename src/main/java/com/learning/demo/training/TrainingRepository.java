package com.learning.demo.training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TrainingRepository extends JpaRepository<TrainingEntity, UUID> {

    @Query(
       value = "SELECT * FROM trainings WHERE subscription_level <= :subscriptionLevel AND date = :date",
       nativeQuery = true
    )
    List<TrainingEntity> getAllTrainingsForDateAndSubscriptionLevel(LocalDate date, Integer subscriptionLevel);
}
