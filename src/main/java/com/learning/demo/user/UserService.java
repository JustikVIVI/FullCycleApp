package com.learning.demo.user;

import org.openapitools.model.CreateUserRequest;
import org.openapitools.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserInfo getUser(UUID userId) {
        return null; // TODO
    }

    public UserInfo createUser(CreateUserRequest createUserRequest) {
        return null; // TODO
    }

    private UserInfo from(UserEntity entity) {
        return null; // TODO
    }
}
