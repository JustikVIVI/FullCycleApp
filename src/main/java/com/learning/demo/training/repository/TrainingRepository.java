package com.learning.demo.training.repository;

import com.learning.demo.training.models.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<TrainingEntity, String> {
}
