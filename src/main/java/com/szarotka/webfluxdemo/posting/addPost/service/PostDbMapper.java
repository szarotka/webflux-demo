package com.szarotka.webfluxdemo.posting.addPost.service;

import java.time.LocalDateTime;

import com.szarotka.webfluxdemo.common.mapper.IdMapper;
import com.szarotka.webfluxdemo.posting.addPost.AddPostRequest;
import com.szarotka.webfluxdemo.posting.common.db.PostDb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = IdMapper.class)
public interface PostDbMapper {

  @Mapping(target = "creationDate", expression = "java( getCurrentDateTime() )")
  @Mapping(target = "id", ignore = true)
  PostDb map(AddPostRequest postRequest);

  default LocalDateTime getCurrentDateTime() {
    return LocalDateTime.now();
  }
}
