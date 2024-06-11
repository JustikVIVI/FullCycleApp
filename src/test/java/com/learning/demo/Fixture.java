package com.learning.demo;

import com.learning.demo.subscription.SubscriptionEntity;

import java.util.UUID;

public class Fixture {
    static public SubscriptionEntity getDefaultSubscriptionEntity() {
        var entity = new SubscriptionEntity();
        entity.setId(UUID.fromString("a9cf7d30-f7c2-475d-9bfe-b3e3607d0d85"));
        entity.setName(SubscriptionEntity.SubscriptionType.FREE);
        entity.setLevel(1);

        return entity;
    }
}
