package com.szarotka.webfluxdemo.performance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlowExternalService {

    @GetMapping("slowExternalService")
    public String callExternalService() throws InterruptedException {
        Thread.sleep(500); // 500ms == 0.5s
        return "Hello world!";
    }
}
