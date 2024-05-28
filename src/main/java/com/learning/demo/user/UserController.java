package com.learning.demo.user;

import com.learning.demo.user.repository.UserRepository;
import org.openapitools.api.UserApi;
import org.openapitools.model.CreateUserRequest;
import org.openapitools.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class UserController implements UserApi {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserInfo> createUser(CreateUserRequest createUserRequest) {
        return UserApi.super.createUser(createUserRequest);
    }

    @Override
    public ResponseEntity<UserInfo> getUser(UUID userId) {
        return UserApi.super.getUser(userId);
    }
}
