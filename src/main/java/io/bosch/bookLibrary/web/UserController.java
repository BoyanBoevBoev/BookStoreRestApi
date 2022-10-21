package io.bosch.bookLibrary.web;

import io.bosch.bookLibrary.entity.dto.UserDTO;
import io.bosch.bookLibrary.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") Long id) {
        userService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO, UriComponentsBuilder uriComponentsBuilder) {
        long userId = userService.createUser(userDTO);
        URI location = uriComponentsBuilder.path("/users/{id}")
                .buildAndExpand(userId).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) {
        UserDTO updatedUser = userService.updateUser(userDTO, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
