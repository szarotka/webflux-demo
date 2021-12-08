package com.szarotka.webfluxdemo.errorhandling;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ErrorHandlingExampleControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void calculate_returnError501() {
        // WHEN
        var response =
                webClient
                        .get()
                        .uri("/calculateThrowsError")
                        .exchange()
                        .expectStatus()
                        .is5xxServerError();
    }

    @Test
    void calculate_returnDefaultValue() {
        // WHEN
        var response =
                webClient
                        .get()
                        .uri("/calculate")
                        .exchange()
                        .expectStatus()
                        .isOk()
                        .expectBody(BigDecimal.class)
                        .returnResult()
                        .getResponseBody();

        // THEN
        assertThat(response).isNotNull();
        assertThat(response).isEqualTo(new BigDecimal(99));
    }

    @Test
    void calculate_resume() {
        // WHEN
        var response =
                webClient
                        .get()
                        .uri("/calculateResume")
                        .exchange()
                        .expectStatus()
                        .isOk()
                        .expectBody(BigDecimal.class)
                        .returnResult()
                        .getResponseBody();

        // THEN
        assertThat(response).isNotNull();
        assertThat(response).isEqualTo(new BigDecimal(4));
    }

    @Test
    void calculate_returnError400() {
        // WHEN
        var response =
                webClient
                        .get()
                        .uri("/calculateThrows400")
                        .exchange()
                        .expectStatus()
                        .is4xxClientError();
    }
}