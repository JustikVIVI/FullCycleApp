package com.learning.demo.user;

import org.openapitools.api.UserApi;
import org.openapitools.model.CreateUserRequest;
import org.openapitools.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class UserController implements UserApi {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<UserInfo> createUser(CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(service.createUser(createUserRequest));
    }

    @Override
    public ResponseEntity<UserInfo> getUser(UUID userId) {
        return ResponseEntity.ok(service.getUser(userId));
    }
}
