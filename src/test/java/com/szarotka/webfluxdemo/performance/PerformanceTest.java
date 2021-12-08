package com.szarotka.webfluxdemo.performance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

//Parameter was added to test blocking service, default timeout is 5000 ms
@AutoConfigureWebTestClient(timeout = "36000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PerformanceTest {

    private static final int NUMBER_OF_REQUESTS = 1000;

    @Autowired
    private WebTestClient webTestClient;

    //Processing 1000 requests took PT1M44.1045473S
    //Processing 10000 requests took PT15M11.6822425S
    // @Test ///Run test only manually
    void blockingApproachTest() {
        // GIVEN
        LocalDateTime start = LocalDateTime.now();
        Collection<RecursiveTask<String>> tasks =
                IntStream.range(0, NUMBER_OF_REQUESTS)
                        .mapToObj(i -> createNewTask("/gatherImportantDataBlocking"))
                        .collect(Collectors.toList());

        // WHEN
        var responses = new ArrayList<>(ForkJoinTask.invokeAll(tasks));

        // THEN
        assertThat(responses).isNotNull();
        assertThat(responses).hasSize(NUMBER_OF_REQUESTS);
        System.out.println("Processing " + NUMBER_OF_REQUESTS + " requests took " + Duration.between(start, LocalDateTime.now()));
    }

    //Processing 1000 requests took PT1M11.4138035S
    //Processing 10000 requests took PT12M0.9205523S
    // @Test // Run test only manually
    void nonblockingApproachTest() {
        // GIVEN
        LocalDateTime start = LocalDateTime.now();
        Collection<RecursiveTask<String>> tasks =
                IntStream.range(0, NUMBER_OF_REQUESTS)
                        .mapToObj(i -> createNewTask("/gatherImportantData"))
                        .collect(Collectors.toList());

        // WHEN
        var responses = new ArrayList<>(ForkJoinTask.invokeAll(tasks));

        // THEN
        assertThat(responses).isNotNull();
        assertThat(responses).hasSize(NUMBER_OF_REQUESTS);
        System.out.println("Processing " + NUMBER_OF_REQUESTS + " requests took " + Duration.between(start, LocalDateTime.now()));
    }

    private RecursiveTask<String> createNewTask(String uri) {
        return new RecursiveTask<>() {
            @Override
            protected String compute() {
                return find(uri);
            }
        };
    }

    private String find(String uri) {
        return webTestClient
                .get()
                .uri(uri)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .returnResult()
                .getResponseBody();
    }
}
