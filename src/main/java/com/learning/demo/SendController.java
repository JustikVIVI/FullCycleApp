package com.learning.demo;

import org.openapitools.api.SendApi;
import org.openapitools.api.SendApi;
import org.openapitools.model.HelloWorldApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class SendController implements SendApi {

    @Override
    // TODO: lets create a possible problems
    public ResponseEntity<HelloWorldApiResponse> getMeme() {
        HelloWorldApiResponse response = new HelloWorldApiResponse();
        response.setValue("SEND NUDES");
        response = null;
        response.setValue("hello");
        return ResponseEntity.ok(response);
    }
}
