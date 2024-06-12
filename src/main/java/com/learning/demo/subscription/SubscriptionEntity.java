package com.learning.demo.subscription;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "subscription")
public class SubscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private SubscriptionType name;

    private Integer level;

    public SubscriptionEntity() {
    }

    public SubscriptionEntity(UUID id, SubscriptionType name, Integer level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SubscriptionType getName() {
        return name;
    }

    public void setName(SubscriptionType name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public enum SubscriptionType {
        FREE, S, M, L, XL
    }
}
