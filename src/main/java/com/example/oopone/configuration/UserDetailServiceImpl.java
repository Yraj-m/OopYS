//package com.example.oopone.configuration;
//
//import com.example.oopone.configuration.MyUserDetail;
//import com.example.oopone.model.User;
//import com.example.oopone.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService {
//
//    @Autowired
//    UserRepo userRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user=userRepo.findUserByUsername(username).get();
//
//        if(user==null){
//            throw new UsernameNotFoundException("username not found");
//        }
//        return new MyUserDetail(user);
//    }
//
//}
