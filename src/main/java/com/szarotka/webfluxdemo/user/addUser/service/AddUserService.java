package com.szarotka.webfluxdemo.user.addUser.service;

import com.szarotka.webfluxdemo.user.addUser.AddUserRequest;
import com.szarotka.webfluxdemo.user.addUser.AddUserResponse;
import com.szarotka.webfluxdemo.user.common.db.UserDbRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class AddUserService {

    private final UserDbMapper userDbMapper;
    private final UserDbRepository userDbRepository;
    private final AddUserResponseMapper addUserResponseMapper;

    public Mono<AddUserResponse> addUser(Mono<AddUserRequest> addUserRequest) {
        return addUserRequest
                .map(userDbMapper::map)
                .flatMap(userDbRepository::save)
                .map(addUserResponseMapper::map);
    }
}
