package com.learning.demo;

import org.openapitools.api.HelloApi;
import org.openapitools.model.HelloWorldApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class HelloWorldController implements HelloApi {

    @Override
    public ResponseEntity<HelloWorldApiResponse> getHello() {
        HelloWorldApiResponse response = new HelloWorldApiResponse();
        response.value("Helloworld");

        return ResponseEntity.ok(response);
    }
}
