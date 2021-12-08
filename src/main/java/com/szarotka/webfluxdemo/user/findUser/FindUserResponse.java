package com.szarotka.webfluxdemo.user.findUser;

import lombok.Value;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Value
public class FindUserResponse {

    ObjectId id;

    String firstName;

    String lastName;

    LocalDateTime creationDate;
}
