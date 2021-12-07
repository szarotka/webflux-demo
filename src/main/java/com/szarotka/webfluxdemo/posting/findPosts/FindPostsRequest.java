package com.szarotka.webfluxdemo.posting.findPosts;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class FindPostsRequest {

    Long id;

    String content;

    LocalDateTime creationDate;
}
