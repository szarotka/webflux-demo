package com.szarotka.webfluxdemo.user.addUser.service;

import com.szarotka.webfluxdemo.common.mapper.IdMapper;
import com.szarotka.webfluxdemo.user.addUser.AddUserResponse;
import com.szarotka.webfluxdemo.user.common.db.UserDb;
import org.mapstruct.Mapper;

@Mapper(uses = IdMapper.class)
public interface AddUserResponseMapper {

    AddUserResponse map(UserDb userDb);
}
