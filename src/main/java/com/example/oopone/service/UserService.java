package com.example.oopone.service;

import com.example.oopone.model.User;
import com.example.oopone.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public void removeUser(int id){
        userRepo.deleteById(id);
    }
}
