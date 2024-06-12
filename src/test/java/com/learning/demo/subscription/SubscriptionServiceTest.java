package com.learning.demo.subscription;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static com.learning.demo.Fixture.getDefaultSubscriptionEntity;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceTest {

    @Mock
    private SubscriptionRepository subscriptionRepository;

    private SubscriptionService service;

    @BeforeEach
    public void setUp() {
        service = new SubscriptionService(subscriptionRepository);
    }

    @Test
    public void testSubscriptionService_whenInitialized_thenNotNull() {
        assertNotNull(service);
    }

    @Test
    public void testGetAllSubscriptions_whenCalled_thenRepositoryMethodIsInvoked() {
        // Arrange
        when(subscriptionRepository.findAll()).thenReturn(List.of(getDefaultSubscriptionEntity()));

        // Act
        service.getAllSubscriptions();

        // Assert
        verify(subscriptionRepository).findAll();
    }

    @Test
    public void testGetSubscriptionById_whenCalled_thenRepositoryMethodIsInvoked() {
        // Arrange
        var id = UUID.randomUUID();
        when(subscriptionRepository.getReferenceById(any())).thenReturn(getDefaultSubscriptionEntity());

        // Act
        service.getSubscriptionById(id);

        // Assert
        verify(subscriptionRepository).getReferenceById(id);
    }
}