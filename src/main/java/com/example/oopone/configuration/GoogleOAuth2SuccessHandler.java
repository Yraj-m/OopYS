//package com.example.oopone.configuration;
//
//import com.example.oopone.model.Role;
//import com.example.oopone.model.User;
//import com.example.oopone.repository.RoleRepo;
//import com.example.oopone.repository.UserRepo;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class GoogleOAuth2SuccessHandler {
//    @Autowired
//    UserRepo userRepo;
//
//    @Autowired
//    RoleRepo roleRepo;
//
//    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
//        String email = token.getPrincipal().getAttributes().get("email").toString();
//        if(userRepo.findUserByEmailid(email).isPresent()){
//
//        }
//        else{
//            User user = new User();
//            user.setUsername(token.getPrincipal().getAttributes().get("given_name").toString());
//            user.setEmailid(email);
//            List<Role> roles = new ArrayList<>();
//            roles.add(roleRepo.findById(3).get());
//            user.setRoles(roles);
//            userRepo.save(user);
//        }
//        redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse,"/");
//    }
