package com.szarotka.webfluxdemo.user.addUser;

import com.szarotka.webfluxdemo.user.addUser.service.AddUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Configuration
@RequiredArgsConstructor
public class AddUserControllerV2 {

    private final AddUserService addUserService;

    @Bean
    public RouterFunction<ServerResponse> addUser() {
        return route(PUT("/user/v2/add"),
                request ->
                        ok().body(addUserService.addUser(request.body(toMono(AddUserRequest.class))), AddUserResponse.class));
    }
}
