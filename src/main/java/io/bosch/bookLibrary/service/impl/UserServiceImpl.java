package io.bosch.bookLibrary.service.impl;

import io.bosch.bookLibrary.entity.UserEntity;
import io.bosch.bookLibrary.entity.dto.UserDTO;
import io.bosch.bookLibrary.repository.UserRepository;
import io.bosch.bookLibrary.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::asUser)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            userRepository.delete(userEntity.get());
        } else {
            //TODO
        }
        userEntity.ifPresent(userRepository::delete);
    }

    @Override
    public long createUser(UserDTO userDTO) {
        //TODO IF NOT FOUND
        UserEntity userEntity = userRepository.findByName(userDTO.getName())
                .orElseGet(UserEntity::new);
        userEntity.setName(userDTO.getName());
        userEntity.setAge(userDTO.getAge());
        userEntity.setEmail(userDTO.getEmail());
        return userRepository.save(userEntity).getId();
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        //  UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> ResourceNotFoundException(""));
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            UserEntity user = userEntity.get();
            user.setName(userDTO.getName());
            user.setAge(userDTO.getAge());
            user.setEmail(userDTO.getEmail());
            userRepository.save(user);
            return asUser(user);
        } else {
            //TODO
            return null;
        }

    }

    private UserDTO asUser(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
}
