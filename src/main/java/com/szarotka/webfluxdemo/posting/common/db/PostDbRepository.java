package com.szarotka.webfluxdemo.posting.common.db;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PostDbRepository extends ReactiveMongoRepository<PostDb, ObjectId> {

}
