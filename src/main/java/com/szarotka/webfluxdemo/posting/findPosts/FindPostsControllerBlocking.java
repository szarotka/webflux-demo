package com.szarotka.webfluxdemo.posting.findPosts;

import com.szarotka.webfluxdemo.posting.findPosts.service.FindPostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("post")
@AllArgsConstructor
public class FindPostsControllerBlocking {

    private final FindPostsService findPostsService;

    @GetMapping("findPostsBlocking/{userId}")
    public FindPostsResponse findPosts(@PathVariable Long userId) {
        return findPostsService.findUserPosts(userId).blockFirst();
    }
}
