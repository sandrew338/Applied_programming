package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        User user = new User(null, userDTO.getName(), userDTO.getEmail(), userDTO.getPhoneNumber(), null);
        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail(), savedUser.getPhoneNumber());
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhoneNumber())).toList();
    }

    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> new UserDTO(value.getId(), value.getName(), value.getEmail(), value.getPhoneNumber()))
                .orElse(null);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User updatedUser = new User(id, userDTO.getName(), userDTO.getEmail(), userDTO.getPhoneNumber(), null);
        userRepository.update(id, updatedUser);
        return userDTO;
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

}
