package com.szarotka.webfluxdemo.posting.common.db;

import lombok.Value;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Value
@Document(collection = "posts")
public class PostDb {

    @Id
    ObjectId id;

    String content;

    LocalDateTime creationDate;
}
