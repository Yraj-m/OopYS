package com.example.oopone.service;


import com.example.oopone.model.User;
import com.example.oopone.dto.UserDto;
import com.example.oopone.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;



    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public UserDto getUserById(int id) {

        UserDto userDto = new UserDto(userRepo.findById(id).get());

        return userDto;
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public void removeUser(int id){
        userRepo.deleteById(id);
    }


}
