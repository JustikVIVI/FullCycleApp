package com.learning.demo.subscription.models;

import jakarta.persistence.*;

@Entity(name = "subscription")
public class SubscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private SubscriptionType name;

    private Integer level;

    public enum SubscriptionType {
        FREE, S, M, L, XL
    }
}
