package com.learning.demo;

import org.openapitools.api.DefaultApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class HomepageController implements DefaultApi {

    @Override
    public ResponseEntity<String> getHomepage() {
        return ResponseEntity.ok("""
                <!DOCTYPE html>
                <html lang='en'>
                <head>
                    <meta charset="utf-8"/>
                    <title>FULL CYCLE APP</title>
                </head>
                <body>
                <H1>
                    HELLO TO MY LEARNING APP! This is just a default placeholder because why not? most of the features are under development rn.
                </H1>
                <img src="https://preview.redd.it/4mrkpih7ok941.jpg?width=640&crop=smart&auto=webp&s=e5dce24afa463fb150c8a14f375870212ac7d24a"
                     alt="meetings"/>
                </body>
                </html>
                """);
    }
}
