package com.szarotka.webfluxdemo.user.common.db;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserDbRepository extends ReactiveMongoRepository<UserDb, ObjectId> {

}
