package com.learning.demo.user;

import com.learning.demo.subscription.SubscriptionEntity;
import com.learning.demo.subscription.SubscriptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.SubscriptionInfo;
import org.openapitools.model.UserInfo;

import java.util.UUID;

import static com.learning.demo.Fixture.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private SubscriptionRepository subscriptionRepository;

    @Captor
    private ArgumentCaptor<UserEntity> userEntityArgumentCaptor;

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService(userRepository, subscriptionRepository);
    }

    @Test
    public void testGetUser_shouldReturnUserInfo() {
        // Given
        UUID userId = UUID.randomUUID();
        SubscriptionEntity subscriptionEntity = new SubscriptionEntity(UUID.randomUUID(), SubscriptionEntity.SubscriptionType.FREE, 1);

        when(userRepository.getReferenceById(userId)).thenReturn(userEntity);
        when(subscriptionRepository.getReferenceById(userEntity.getSubscriptionId())).thenReturn(subscriptionEntity);

        // When
        UserInfo userInfo = userService.getUser(userId);

        // Then
        assertNotNull(userInfo);
        assertEquals(userEntity.getId(), userInfo.getId());
        assertEquals(userEntity.getEmail(), userInfo.getEmail());
        assertEquals(subscriptionEntity.getId(), userInfo.getSubscription().getId());
        assertEquals(subscriptionEntity.getLevel(), userInfo.getSubscription().getSubscriptionLevel());
        assertEquals(SubscriptionInfo.TypeEnum.fromValue(subscriptionEntity.getName().toString()), userInfo.getSubscription().getType());
        assertEquals(userEntity.getDateRegistered(), userInfo.getRegistrationDate());
    }

    @Test
    public void testCreateUser_shouldSaveUserAndReturnUserInfo() {
        // Given

        when(subscriptionRepository.getReferenceById(any(UUID.class))).thenReturn(subscriptionEntity);

        // When
        UserInfo userInfo = userService.createUser(createUserRequest);

        // Then
        verify(userRepository).save(userEntityArgumentCaptor.capture());
        UserEntity savedUserEntity = userEntityArgumentCaptor.getValue();
        assertNotNull(userInfo);
        assertEquals(savedUserEntity.getId(), userInfo.getId());
        assertEquals(savedUserEntity.getEmail(), userInfo.getEmail());
        assertEquals(subscriptionEntity.getId(), userInfo.getSubscription().getId());
        assertEquals(subscriptionEntity.getLevel(), userInfo.getSubscription().getSubscriptionLevel());
        assertEquals(SubscriptionInfo.TypeEnum.fromValue(subscriptionEntity.getName().toString()), userInfo.getSubscription().getType());
        assertEquals(savedUserEntity.getDateRegistered(), userInfo.getRegistrationDate());
    }

    // Maybe I need to add more tests here
}