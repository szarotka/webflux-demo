package com.szarotka.webfluxdemo.performance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GatherImportantDataBlockingController {

    private final static String URI = "http://localhost:8081/slowExternalService";
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("gatherImportantDataBlocking")
    public String gatherImportantData() {
        return restTemplate.getForObject(URI, String.class);
    }
}
