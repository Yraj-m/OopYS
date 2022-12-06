package com.example.oopone.repository;

import com.example.oopone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findUserByEmailid(String email);

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserById(int id);


}