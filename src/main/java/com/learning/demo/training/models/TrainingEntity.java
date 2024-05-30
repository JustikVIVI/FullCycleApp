package com.learning.demo.training.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "trainings")
public class TrainingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String date;

    private Integer subscriptionLevel;

    private TrainingType trainingType;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSubscriptionLevel() {
        return subscriptionLevel;
    }

    public void setSubscriptionLevel(Integer subscriptionLevel) {
        this.subscriptionLevel = subscriptionLevel;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

    private enum TrainingType {
        POOOOWER, YOGA, CHILLING
    }
}
