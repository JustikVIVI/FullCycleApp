package com.learning.demo;

import org.openapitools.api.SendApi;
import org.openapitools.model.HelloWorldApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public final class SendController implements SendApi {

    @Override
    public ResponseEntity<HelloWorldApiResponse> getMeme() {
        HelloWorldApiResponse response = new HelloWorldApiResponse();
        response.setValue("SEND NUDES");
        return ResponseEntity.ok(response);
    }
}
