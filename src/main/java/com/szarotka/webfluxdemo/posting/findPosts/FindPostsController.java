package com.szarotka.webfluxdemo.posting.findPosts;

import com.szarotka.webfluxdemo.posting.findPosts.service.FindPostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("post")
@AllArgsConstructor
public class FindPostsController {

    private final FindPostsService findPostsService;

    @GetMapping("findPosts/{userId}")
    public Flux<FindPostsResponse> findPosts(@PathVariable Long userId) {
        return findPostsService.findUserPosts(userId);
    }

    @GetMapping("findPost/{id}")
    public Mono<FindPostsResponse> findPost(@PathVariable String id) {
        return findPostsService.find(id);
    }

    @GetMapping("findPostBlocking/{id}")
    public FindPostsResponse findPostBlocking(@PathVariable String id) {
        return findPostsService.find(id).block();
    }
}
