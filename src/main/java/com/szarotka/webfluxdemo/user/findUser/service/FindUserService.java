package com.szarotka.webfluxdemo.user.findUser.service;

import com.szarotka.webfluxdemo.user.common.db.UserDbRepository;
import com.szarotka.webfluxdemo.user.findUser.FindUserResponse;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class FindUserService {

    private final UserDbRepository userDbRepository;
    private final FindUserResponseMapper findUserResponseMapper;

    public Flux<FindUserResponse> findAllUsers() {
        return userDbRepository.findAll()
                .map(findUserResponseMapper::map);
    }

    public Mono<FindUserResponse> find(String id) {
        return userDbRepository.findById(new ObjectId(id))
                .map(findUserResponseMapper::map);
    }
}
