package com.szarotka.webfluxdemo.posting.findPosts;

import lombok.Value;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Value
public class FindPostsResponse {

    ObjectId id;

    String content;

    LocalDateTime creationDate;
}
