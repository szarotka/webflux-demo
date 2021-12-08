package com.szarotka.webfluxdemo.user.findUser;

import com.szarotka.webfluxdemo.user.findUser.service.FindUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class FindUserController {

    private final FindUserService findUserService;

    @GetMapping("findUsers")
    public Flux<FindUserResponse> findAllUsers() {
        return findUserService.findAllUsers();
    }

    @GetMapping("findUser/{id}")
    public Mono<FindUserResponse> findUser(@PathVariable String id) {
        return findUserService.find(id);
    }

    @GetMapping("findUserBlocking/{id}")
    public FindUserResponse findUserBlocking(@PathVariable String id) {
        return findUserService.find(id).block();
    }
}
