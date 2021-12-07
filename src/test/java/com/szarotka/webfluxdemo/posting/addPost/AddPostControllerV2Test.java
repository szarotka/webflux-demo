package com.szarotka.webfluxdemo.posting.addPost;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddPostControllerV2Test {

    @Autowired
    private WebTestClient webClient;

    @Test
    void addPost() {
        // GIVEN
        var content = "message";
        var addPostRequest = new AddPostRequest(content);

        // WHEN
        var response =
                webClient
                        .put()
                        .uri("/post/v2/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(addPostRequest))
                        .exchange()
                        .expectStatus()
                        .isOk()
                        .expectBody(AddPostResponse.class)
                        .returnResult()
                        .getResponseBody();

        // THEN
        assertThat(response).isNotNull();
        assertThat(response.getId()).isNotNull();
        assertThat(response.getCreationDate()).isNotNull();
        assertThat(response.getContent()).isEqualTo(content);
    }
}