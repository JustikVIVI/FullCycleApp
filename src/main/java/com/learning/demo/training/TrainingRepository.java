package com.learning.demo.training;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<TrainingEntity, String> {
}
