package com.szarotka.webfluxdemo.user.findUser;

import com.szarotka.webfluxdemo.user.addUser.AddUserResponse;
import com.szarotka.webfluxdemo.user.addUser.AddUserRequest;
import com.szarotka.webfluxdemo.user.common.db.UserDbRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FindUserControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Autowired
    private UserDbRepository userDbRepository;

    @Test
    void findUsersTest() {
        // GIVEN
        var userId = 123;
        userDbRepository.deleteAll().block();
        addUser();

        // WHEN
        var response =
                webClient
                        .get()
                        .uri("/user/findUsers")
                        .exchange()
                        .expectStatus()
                        .isOk()
                        .expectBodyList(FindUserResponse.class)
                        .returnResult()
                        .getResponseBody();

        // THEN
        assertThat(response).isNotNull();
        assertThat(response).hasSize(1);
    }

    private void addUser() {
        var firstName = "Jan";
        var lastName = "Kowalski";
        var addUserRequest = new AddUserRequest(firstName, lastName);

        webClient
                .put()
                .uri("/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(addUserRequest))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(AddUserResponse.class)
                .returnResult();
    }
}