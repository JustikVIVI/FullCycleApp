package com.learning.demo.subscription;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
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

    @InjectMocks
    private SubscriptionService subscriptionService;

    @Test
    public void testSubscriptionService_whenInitialized_thenNotNull() {
        assertNotNull(subscriptionService);
    }

    @Test
    public void testGetAllSubscriptions_whenCalled_thenRepositoryMethodIsInvoked() {
        // Arrange
        when(subscriptionRepository.findAll()).thenReturn(List.of(getDefaultSubscriptionEntity()));

        // Act
        subscriptionService.getAllSubscriptions();

        // Assert
        verify(subscriptionRepository).findAll();
    }

    @Test
    public void testGetSubscriptionById_whenCalled_thenRepositoryMethodIsInvoked() {
        // Arrange
        var id = UUID.randomUUID();
        when(subscriptionRepository.getReferenceById(any())).thenReturn(getDefaultSubscriptionEntity());

        // Act
        subscriptionService.getSubscriptionById(id);

        // Assert
        verify(subscriptionRepository).getReferenceById(id);
    }
}