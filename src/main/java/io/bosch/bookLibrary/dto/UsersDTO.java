package io.bosch.bookLibrary.dto;

import lombok.Value;

import java.util.List;

@Value
public class UsersDTO {
    List<UserDTO> users;
}
