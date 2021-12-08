package com.szarotka.webfluxdemo.user.addUser;

import com.szarotka.webfluxdemo.user.addUser.service.AddUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class AddUserController {

    private final AddUserService addUserService;

    @PutMapping("add")
    public Mono<AddUserResponse> addUser(@RequestBody Mono<AddUserRequest> addUserRequest) {
        return addUserService.addUser(addUserRequest);
    }
}
