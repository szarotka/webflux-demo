package com.szarotka.webfluxdemo.user.addUser;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddUserRequest {

    String firstName;

    String lastName;

}
