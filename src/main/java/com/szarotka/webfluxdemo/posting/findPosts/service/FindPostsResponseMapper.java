package com.szarotka.webfluxdemo.posting.findPosts.service;

import com.szarotka.webfluxdemo.common.mapper.IdMapper;
import com.szarotka.webfluxdemo.posting.common.db.PostDb;
import com.szarotka.webfluxdemo.posting.findPosts.FindPostsResponse;
import org.mapstruct.Mapper;

@Mapper(uses = IdMapper.class)
public interface FindPostsResponseMapper {

  FindPostsResponse map(PostDb postDb);
}
