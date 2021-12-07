package com.szarotka.webfluxdemo.posting.findPosts;

import com.szarotka.webfluxdemo.posting.addPost.AddPostRequest;
import com.szarotka.webfluxdemo.posting.addPost.AddPostResponse;
import com.szarotka.webfluxdemo.posting.common.db.PostDbRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FindPostsControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Autowired
    private PostDbRepository postDbRepository;

    @Test
    void FindPosts() {
        // GIVEN
        var userId = 123;
        postDbRepository.deleteAll().block();
        addPost();

        // WHEN
        var response =
                webClient
                        .get()
                        .uri("/post/findPosts/{userId}", userId)
                        .exchange()
                        .expectStatus()
                        .isOk()
                        .expectBodyList(FindPostsResponse.class)
                        .returnResult()
                        .getResponseBody();

        // THEN
        assertThat(response).isNotNull();
        assertThat(response).hasSize(1);
    }

    private void addPost() {
        var content = "message";
        var addPostRequest = new AddPostRequest(content);

        webClient
                .put()
                .uri("/post/add")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(addPostRequest))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(AddPostResponse.class)
                .returnResult();
    }
}