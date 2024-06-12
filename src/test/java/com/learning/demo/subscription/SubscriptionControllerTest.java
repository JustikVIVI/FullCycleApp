package com.learning.demo.subscription;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.SubscriptionInfo;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SubscriptionControllerTest {
    @Mock
    private SubscriptionService subscriptionService;

    private SubscriptionController controller;

    @BeforeEach
    void setUp() {
        controller = new SubscriptionController(subscriptionService);
    }

    @Test
    public void getSubscriptions_shouldReturnAllSubscriptions() {
        var subscription = mock(SubscriptionInfo.class);
        when(subscriptionService.getAllSubscriptions()).thenReturn(List.of(subscription));

        controller.getSubscriptions();

        verify(subscriptionService, times(1)).getAllSubscriptions();
    }

    @Test
    public void getSubscriptionById_shouldReturnSubscriptionId() {
        var subscription = mock(SubscriptionInfo.class);
        var uuid = UUID.randomUUID();
        when(subscriptionService.getSubscriptionById(uuid)).thenReturn(subscription);

        controller.getSubscriptionById(uuid);

        verify(subscriptionService, times(1)).getSubscriptionById(uuid);
    }
}