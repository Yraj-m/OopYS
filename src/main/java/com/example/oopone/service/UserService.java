package com.example.oopone.service;


import com.example.oopone.model.User;
import com.example.oopone.dto.UserDto;
import com.example.oopone.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.oopone.exception.UserAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;



    public List<UserDto> getUsers() {

        List<User> userList =  userRepo.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User var : userList){
            userDtoList.add(new UserDto(var));
        }

        return userDtoList;
    }

    public UserDto getUserById(int id) {

        UserDto userDto = new UserDto(userRepo.findById(id).get());

        return userDto;
    }

    public User saveUser(User user) {
        if(userRepo.findUserByEmailid(user.getEmailid()).isPresent())
        {
            throw new UserAlreadyExistsException("User Already Exists");
        }
            return userRepo.save(user);
    }

    public void removeUser(int id){
        userRepo.deleteById(id);
    }


}
