package com.szarotka.webfluxdemo.errorhandling;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ErrorMessage {

  String message;

}
