package com.szarotka.webfluxdemo.performance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class GatherImportantDataNonBlockingController {

    private final WebClient webClient;

    public GatherImportantDataNonBlockingController() {
        this.webClient = WebClient.create("http://localhost:8081");
    }

    @GetMapping("gatherImportantData")
    public Mono<String> gatherImportantData() {
        return webClient.get()
                .uri("slowExternalService")
                .retrieve()
                .bodyToMono(String.class);
    }
}
