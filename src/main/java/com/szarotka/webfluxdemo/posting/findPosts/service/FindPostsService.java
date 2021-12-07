package com.szarotka.webfluxdemo.posting.findPosts.service;

import com.szarotka.webfluxdemo.posting.common.db.PostDbRepository;
import com.szarotka.webfluxdemo.posting.findPosts.FindPostsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class FindPostsService {

    private final PostDbRepository postDbRepository;
    private final FindPostsResponseMapper findPostsResponseMapper;

    public Flux<FindPostsResponse> findUserPosts(Long userId) {
        return postDbRepository.findAll()
                .map(findPostsResponseMapper::map);
    }
}