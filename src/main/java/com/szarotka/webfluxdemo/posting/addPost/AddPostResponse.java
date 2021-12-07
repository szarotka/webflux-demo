package com.szarotka.webfluxdemo.posting.addPost;

import lombok.Value;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Value
public class AddPostResponse {

    ObjectId id;

    String content;

    LocalDateTime creationDate;
}
