package com.szarotka.webfluxdemo.common.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;

@Mapper
public class IdMapper {

  public String map(ObjectId value) {
    return value.toHexString();
  }

  public ObjectId map(String value) {
    return new ObjectId(value);
  }
}
