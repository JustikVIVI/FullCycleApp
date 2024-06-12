package com.learning.demo;

import com.learning.demo.subscription.SubscriptionEntity;
import com.learning.demo.training.TrainingEntity;
import com.learning.demo.user.UserEntity;
import org.openapitools.model.CreateUserRequest;

import java.time.LocalDate;
import java.util.UUID;

public class Fixture {
    static public SubscriptionEntity getDefaultSubscriptionEntity() {
        var entity = new SubscriptionEntity();
        entity.setId(UUID.fromString("a9cf7d30-f7c2-475d-9bfe-b3e3607d0d85"));
        entity.setName(SubscriptionEntity.SubscriptionType.FREE);
        entity.setLevel(1);

        return entity;
    }

    static public TrainingEntity defaultTrainingEntity1 = new TrainingEntity(
            "Power Training",
            LocalDate.of(2022, 1, 1),
            2,
            TrainingEntity.TrainingType.POOOOWER
    );

    static public TrainingEntity defaultTrainingEntity2 = new TrainingEntity(
            "Yoga Session",
            LocalDate.of(2022, 1, 1),
            1,
            TrainingEntity.TrainingType.YOGA
    );

    static public UserEntity userEntity = new UserEntity(
            "John Doe",
            "john.doe@example.com",
            UUID.randomUUID(),
            LocalDate.now()
    );

    static public SubscriptionEntity subscriptionEntity = new SubscriptionEntity(
            UUID.randomUUID(),
            SubscriptionEntity.SubscriptionType.FREE,
            0
    );

    static public CreateUserRequest createUserRequest = new CreateUserRequest(
            "Jane Doe",
            "jane.doe@example.com",
            UUID.randomUUID().toString()
    );
}
