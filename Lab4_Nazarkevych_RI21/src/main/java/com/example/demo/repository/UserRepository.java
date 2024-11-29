package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();
    private Long currentId = 1L;

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(currentId++);
        }
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public void delete(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public void update(Long id, User updatedUser) {
        Optional<User> existingUserOpt = findById(id);
        existingUserOpt.ifPresent(existingUser -> {
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            existingUser.setBookings(updatedUser.getBookings());
        });
    }
}
