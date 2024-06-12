package com.learning.demo.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.CreateUserRequest;
import org.openapitools.model.UserInfo;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    private UserController userController;

    @BeforeEach
    public void setUp() {
        userController = new UserController(userService);
    }

    @Test
    public void createUser_shouldReturnCreatedUser() {
        var userInfo = mock(UserInfo.class);
        var createUserRequest = mock(CreateUserRequest.class);
        when(userService.createUser(any(CreateUserRequest.class))).thenReturn(userInfo);

        userController.createUser(createUserRequest);

        verify(userService, times(1)).createUser(any());
    }

    @Test
    public void getUser_shouldReturnUserById() {
        var userInfo = mock(UserInfo.class);
        var userId = UUID.randomUUID();

        when(userService.getUser(userId)).thenReturn(userInfo);

        userController.getUser(userId);

        verify(userService, times(1)).getUser(userId);
    }
}
