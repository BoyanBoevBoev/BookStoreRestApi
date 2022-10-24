package io.bosch.bookLibrary.service;

import io.bosch.bookLibrary.entity.User;
import io.bosch.bookLibrary.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void deleteBook(long id);

    User createUser(UserDTO userDTO);

    User updateUser(UserDTO userDTO, Long id);
}
