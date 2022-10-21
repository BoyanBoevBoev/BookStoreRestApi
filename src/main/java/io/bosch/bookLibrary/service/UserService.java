package io.bosch.bookLibrary.service;

import io.bosch.bookLibrary.entity.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    void deleteBook(long id);

    long createUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO, Long id);
}
