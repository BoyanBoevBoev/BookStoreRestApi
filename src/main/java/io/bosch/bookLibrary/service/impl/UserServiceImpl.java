package io.bosch.bookLibrary.service.impl;

import io.bosch.bookLibrary.entity.User;
import io.bosch.bookLibrary.dto.UserDTO;
import io.bosch.bookLibrary.repository.UserRepository;
import io.bosch.bookLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteBook(long id) {
        Optional<User> userEntity = userRepository.findById(id);
       userEntity.isEmpty(userEntity.orElseThrow(() -> ResourceNotFoundException("")));
        userEntity.ifPresent(userRepository::delete);

    }

    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User();
       user.setName(userDTO.getName());
      user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        return userRepository.save(user);

    }

    @Override
   public User updateUser(UserDTO userDTO, Long id) {
       User user = userRepository.findById(id).orElseThrow(() -> ResourceNotFoundException(""));
       user.setName(user.getName());
       user.setAge(user.getAge());
       user.setEmail(user.getEmail());
        return user;

   }


}
