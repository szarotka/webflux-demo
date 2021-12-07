package com.szarotka.webfluxdemo.posting.addPost;

import com.szarotka.webfluxdemo.posting.addPost.service.AddPostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("post")
@AllArgsConstructor
public class AddPostController {

    private final AddPostService addPostService;

    @PutMapping("add")
    public Mono<AddPostResponse> addPost(@RequestBody Mono<AddPostRequest> addPostRequest) {
        return addPostService.addPost(addPostRequest);
    }
}
