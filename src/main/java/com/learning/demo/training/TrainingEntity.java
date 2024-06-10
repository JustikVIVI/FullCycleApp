package com.learning.demo.training;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "trainings")
public class TrainingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    private Integer subscriptionLevel;

    @Enumerated(EnumType.STRING)
    private TrainingType type;

    public TrainingEntity() { }

    public TrainingEntity(String name, LocalDate date, Integer subscriptionLevel, TrainingType type) {
        this.name = name;
        this.date = date;
        this.subscriptionLevel = subscriptionLevel;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getSubscriptionLevel() {
        return subscriptionLevel;
    }

    public void setSubscriptionLevel(Integer subscriptionLevel) {
        this.subscriptionLevel = subscriptionLevel;
    }

    public TrainingType getType() {
        return type;
    }

    public void setType(TrainingType type) {
        this.type = type;
    }

    public enum TrainingType {
        POOOOWER, YOGA, CHILLING
    }
}
