package com.learning.demo.subscription.repository;

import com.learning.demo.subscription.models.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, String> {
}
