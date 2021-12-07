package com.szarotka.webfluxdemo.posting.addPost;

import com.szarotka.webfluxdemo.posting.addPost.service.AddPostService;
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
public class AddPostControllerV2 {

    private final AddPostService addPostService;

    @Bean
    public RouterFunction<ServerResponse> addPost() {
        return route(PUT("/post/v2/add"),
                request ->
                        ok().body(addPostService.addPost(request.body(toMono(AddPostRequest.class))), AddPostResponse.class));
    }
}
