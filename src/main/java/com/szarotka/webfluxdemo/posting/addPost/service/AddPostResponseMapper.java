package com.szarotka.webfluxdemo.posting.addPost.service;

import com.szarotka.webfluxdemo.common.mapper.IdMapper;
import com.szarotka.webfluxdemo.posting.addPost.AddPostResponse;
import com.szarotka.webfluxdemo.posting.common.db.PostDb;
import org.mapstruct.Mapper;

@Mapper(uses = IdMapper.class)
public interface AddPostResponseMapper {

    AddPostResponse map(PostDb postDb);
}
