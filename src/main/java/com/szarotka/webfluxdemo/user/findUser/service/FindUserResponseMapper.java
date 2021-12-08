package com.szarotka.webfluxdemo.user.findUser.service;

import com.szarotka.webfluxdemo.common.mapper.IdMapper;
import com.szarotka.webfluxdemo.user.common.db.UserDb;
import com.szarotka.webfluxdemo.user.findUser.FindUserResponse;
import org.mapstruct.Mapper;

@Mapper(uses = IdMapper.class)
public interface FindUserResponseMapper {

    FindUserResponse map(UserDb userDb);
}
