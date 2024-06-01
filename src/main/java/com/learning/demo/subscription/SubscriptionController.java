package com.learning.demo.subscription;

import org.openapitools.api.SubscriptionApi;
import org.openapitools.model.SubscriptionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class SubscriptionController implements SubscriptionApi {

    private SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<SubscriptionInfo>> getSubscriptions() {
        return ResponseEntity.ok(service.getAllSubscriptions());
    }

    @Override
    public ResponseEntity<SubscriptionInfo> getSubscriptionById(UUID subscriptionId) {
        return ResponseEntity.ok(service.getSubscriptionById(subscriptionId));
    }
}
