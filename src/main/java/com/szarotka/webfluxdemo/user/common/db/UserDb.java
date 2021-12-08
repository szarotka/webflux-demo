package com.szarotka.webfluxdemo.user.common.db;

import lombok.Value;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Value
@Document(collection = "users")
public class UserDb {

    @Id
    ObjectId id;

    String firstName;

    String lastName;

    LocalDateTime creationDate;
}
