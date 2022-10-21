package io.bosch.bookLibrary.entity.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private int age;
    private String email;
}
