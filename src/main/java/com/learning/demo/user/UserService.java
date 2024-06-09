package com.learning.demo.user;

import com.learning.demo.subscription.SubscriptionEntity;
import com.learning.demo.subscription.SubscriptionRepository;
import org.openapitools.model.CreateUserRequest;
import org.openapitools.model.SubscriptionInfo;
import org.openapitools.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repository;
    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public UserService(UserRepository repository, SubscriptionRepository subscriptionRepository) {
        this.repository = repository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public UserInfo getUser(UUID userId) {
        var user = repository.getReferenceById(userId);
        var subscription = subscriptionRepository.getReferenceById(user.getSubscriptionId());
        return from(user, subscription);
    }

    public UserInfo createUser(CreateUserRequest createUserRequest) {
        var subscriptionUUID = UUID.fromString(createUserRequest.getSubscriptionId());
        var subscription = subscriptionRepository.getReferenceById(subscriptionUUID);
        var createdUser = new UserEntity(
                createUserRequest.getName(),
                createUserRequest.getEmail(),
                subscriptionUUID,
                LocalDate.now()
        );
        repository.save(createdUser);

        return from(createdUser, subscription);
    }

    private UserInfo from(UserEntity user, SubscriptionEntity subscription) {
        var subscriptionApi = new SubscriptionInfo(
                subscription.getId(),
                subscription.getLevel(),
                SubscriptionInfo.TypeEnum.fromValue(subscription.getName().toString())
        );

        return new UserInfo(
                user.getId(),
                user.getEmail(),
                subscriptionApi,
                user.getDateRegistered()
        );
    }
}
