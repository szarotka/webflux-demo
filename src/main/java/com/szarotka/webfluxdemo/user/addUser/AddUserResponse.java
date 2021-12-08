package com.szarotka.webfluxdemo.user.addUser;

import lombok.Value;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Value
public class AddUserResponse {

    ObjectId id;

    String firstName;

    String lastName;

    LocalDateTime creationDate;
}
