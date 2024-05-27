package com.learning.demo;

import com.learning.demo.models.HelloWorldEntity;
import com.learning.demo.repository.HelloWorldRepository;
import org.openapitools.api.HelloApi;
import org.openapitools.model.HelloWorldApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorldController implements HelloApi {

    @Autowired
    private HelloWorldRepository repository;

    @Override
    public ResponseEntity<HelloWorldApiResponse> getHello() {
        HelloWorldApiResponse response = new HelloWorldApiResponse();
        addNewEntity(); // TODO: just for tests, remove later
        response.value("Helloworld");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<HelloWorldApiResponse>> getAllHello() {
        List<HelloWorldEntity> result = repository.findAll();
        List<HelloWorldApiResponse> response = new ArrayList<>();

        for (HelloWorldEntity entity : result) {
            HelloWorldApiResponse helloWorldApiResponse = new HelloWorldApiResponse();
            helloWorldApiResponse.setValue(entity.getValue());
            response.add(helloWorldApiResponse);
        }
        return ResponseEntity.ok(response);
    }

    // TODO: just for tests, remove later
    private void addNewEntity() {
        HelloWorldEntity entity = new HelloWorldEntity();
        entity.setValue("Hello from: " + System.currentTimeMillis());
        repository.save(entity);
    }
}
