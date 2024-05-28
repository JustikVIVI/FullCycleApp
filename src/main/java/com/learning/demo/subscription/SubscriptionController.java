package com.learning.demo.subscription;

import org.openapitools.api.SubscriptionApi;
import org.openapitools.model.SubscriptionInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class SubscriptionController implements SubscriptionApi {


    @Override
    public ResponseEntity<List<SubscriptionInfo>> getSubscription() {
        return SubscriptionApi.super.getSubscription();
    }

    @Override
    public ResponseEntity<SubscriptionInfo> getSubscriptionById(UUID subscriptionId) {
        return SubscriptionApi.super.getSubscriptionById(subscriptionId);
    }
}
