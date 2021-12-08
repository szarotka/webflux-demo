package com.szarotka.webfluxdemo.user.addUser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddUserControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void addUser() {
        // GIVEN
        var firstName = "Jan";
        var lastName = "Kowalski";
        var addUserRequest = new AddUserRequest(firstName, lastName);

        // WHEN
        var response =
                webClient
                        .put()
                        .uri("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(addUserRequest))
                        .exchange()
                        .expectStatus()
                        .isOk()
                        .expectBody(AddUserResponse.class)
                        .returnResult()
                        .getResponseBody();

        // THEN
        assertThat(response).isNotNull();
        assertThat(response.getId()).isNotNull();
        assertThat(response.getCreationDate()).isNotNull();
        assertThat(response.getFirstName()).isEqualTo(firstName);
        assertThat(response.getLastName()).isEqualTo(lastName);
    }
}