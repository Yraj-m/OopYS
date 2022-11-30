package com.example.oopone.service;


import com.example.oopone.model.Address;
import com.example.oopone.model.User;
import com.example.oopone.repository.AddressRepo;
import com.example.oopone.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService
{

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    UserRepo userRepo;

    public List<Address> getAddress() {
        return addressRepo.findAll();
    }

    public Optional<Address> getAddressById(int id) {
        return addressRepo.findById(id);
    }

    public Address saveAddress(int id , Address address) {
        User user = userRepo.findById(id).orElse(null);
        address.setUser(user);
        return addressRepo.save(address);
    }


}
