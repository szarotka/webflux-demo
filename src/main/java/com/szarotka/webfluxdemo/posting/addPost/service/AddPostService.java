package com.szarotka.webfluxdemo.posting.addPost.service;

import com.szarotka.webfluxdemo.posting.addPost.AddPostRequest;
import com.szarotka.webfluxdemo.posting.addPost.AddPostResponse;
import com.szarotka.webfluxdemo.posting.common.db.PostDbRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class AddPostService {

    private final PostDbMapper postDbMapper;
    private final PostDbRepository postDbRepository;
    private final AddPostResponseMapper addPostResponseMapper;

    public Mono<AddPostResponse> addPost(Mono<AddPostRequest> post) {
        return post
                .map(postDbMapper::map)
                .flatMap(postDbRepository::save)
                .map(addPostResponseMapper::map);
    }
}
