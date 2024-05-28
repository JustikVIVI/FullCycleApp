package com.learning.demo.subscription;

import com.learning.demo.subscription.repository.SubscriptionRepository;
import org.openapitools.api.SubscriptionApi;
import org.openapitools.model.SubscriptionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class SubscriptionController implements SubscriptionApi {

    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionController(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public ResponseEntity<List<SubscriptionInfo>> getSubscription() {
        return SubscriptionApi.super.getSubscription();
    }

    @Override
    public ResponseEntity<SubscriptionInfo> getSubscriptionById(UUID subscriptionId) {
        return SubscriptionApi.super.getSubscriptionById(subscriptionId);
    }
}
