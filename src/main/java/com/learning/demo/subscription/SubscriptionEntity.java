package com.learning.demo.subscription;

import jakarta.persistence.*;

@Entity(name = "subscription")
public class SubscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private SubscriptionType name;

    private Integer level;

    public String getId() {
        return id;
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
