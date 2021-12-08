package com.szarotka.webfluxdemo.user.addUser.service;

import java.time.LocalDateTime;

import com.szarotka.webfluxdemo.common.mapper.IdMapper;
import com.szarotka.webfluxdemo.user.addUser.AddUserRequest;
import com.szarotka.webfluxdemo.user.common.db.UserDb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = IdMapper.class)
public interface UserDbMapper {

  @Mapping(target = "creationDate", expression = "java( getCurrentDateTime() )")
  @Mapping(target = "id", ignore = true)
  UserDb map(AddUserRequest addUserRequest);

  default LocalDateTime getCurrentDateTime() {
    return LocalDateTime.now();
  }
}
