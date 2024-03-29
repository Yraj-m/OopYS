package com.example.oopone.service;


import com.example.oopone.model.Role;
import com.example.oopone.model.User;
import com.example.oopone.dto.UserDto;
import com.example.oopone.repository.RoleRepo;
import com.example.oopone.repository.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import com.example.oopone.exception.UserAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;
//    BCryptPasswordEncoder bCryptPasswordEncoder;


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

    public UserDto saveUser(User user) {
        if(userRepo.findUserByEmailid(user.getEmailid()).isPresent())
        {
            throw new UserAlreadyExistsException("User Already Exists");
        }
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepo.findById(3).get());
            user.setRoles(roles);
            userRepo.save(user);
            UserDto userDto = new UserDto(user);
            return userDto;
    }
    public void updateUserWallet(User user) {
        User user1 = userRepo.findById(user.getId()).get();
        user1.setWallet_amt(user.getWallet_amt());
        userRepo.save(user1);
    }

    public void removeUser(int id){
        userRepo.deleteById(id);
    }

    public UserDto getUserByUsername(String username){
        UserDto userDto = new UserDto(userRepo.findUserByUsername(username).get());
        return userDto;
    }


}
