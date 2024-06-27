package com.learning.demo.subscription;

import com.learning.demo.mongologs.MongoLog;
import com.learning.demo.mongologs.MongoLogRepository;
import org.openapitools.api.SubscriptionApi;
import org.openapitools.model.SubscriptionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class SubscriptionController implements SubscriptionApi {

    private final SubscriptionService service;
    private final MongoLogRepository logRepository;

    public SubscriptionController(SubscriptionService service, MongoLogRepository repository) {
        this.logRepository = repository;
        this.service = service;
    }

    @Override
    public ResponseEntity<List<SubscriptionInfo>> getSubscriptions() {
        MongoLog log = new MongoLog("getSubscriptionsCalled", "Debug");
        logRepository.save(log);
        return ResponseEntity.ok(service.getAllSubscriptions());
    }

    @Override
    public ResponseEntity<SubscriptionInfo> getSubscriptionById(UUID subscriptionId) {
        return ResponseEntity.ok(service.getSubscriptionById(subscriptionId));
    }
}
