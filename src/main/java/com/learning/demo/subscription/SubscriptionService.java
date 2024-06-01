package com.learning.demo.subscription;

import org.openapitools.model.SubscriptionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionService {
    private final SubscriptionRepository repository;

    @Autowired
    public SubscriptionService(SubscriptionRepository repository) {
        this.repository = repository;
    }

    public List<SubscriptionInfo> getAllSubscriptions() {
        List<SubscriptionEntity> subscriptionsDto = repository.findAll();

        return subscriptionsDto
                .stream()
                .map(this::mapToApi)
                .toList();
    }

    public SubscriptionInfo getSubscriptionById(UUID id) {
        return mapToApi(repository.getReferenceById(id.toString()));
    }

    private SubscriptionInfo mapToApi(SubscriptionEntity entity) {
        return new SubscriptionInfo(
                UUID.fromString(entity.getId()),
                entity.getLevel(),
                from(entity.getName())
        );
    }

    private SubscriptionInfo.TypeEnum from(SubscriptionEntity.SubscriptionType type) {
        SubscriptionInfo.TypeEnum info;
        switch (type) {
            case FREE -> info = SubscriptionInfo.TypeEnum.FREE;
            case S -> info = SubscriptionInfo.TypeEnum.S;
            case M -> info = SubscriptionInfo.TypeEnum.M;
            case L -> info = SubscriptionInfo.TypeEnum.L;
            case XL -> info = SubscriptionInfo.TypeEnum.XL;
            default -> throw new IllegalArgumentException("Type is not supported");
        }

        return info;
    }
}
