package io.bosch.bookLibrary.rest;

import io.bosch.bookLibrary.dto.UsersDTO;
import io.bosch.bookLibrary.entity.User;
import io.bosch.bookLibrary.dto.UserDTO;
import io.bosch.bookLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;


    @GetMapping
    public UsersDTO getAllUsers() {

        List<UserDTO> collect = userService.getAllUsers().stream()
                .map(this::asUser)
                .collect(Collectors.toList());
            UsersDTO usersDTO = new UsersDTO(collect);
            return usersDTO;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteBook(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        return asUser(user);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) {
        User updatedUser = userService.updateUser(userDTO, id);
        return asUser(updatedUser);
    }

    private UserDTO asUser(User userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
}
