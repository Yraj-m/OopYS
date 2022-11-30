package com.example.oopone.configuration;

import com.example.oopone.model.Role;
import com.example.oopone.model.User;
import com.example.oopone.repository.RoleRepo;
import com.example.oopone.repository.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;

    private RedirectStrategy redirectStrategy =new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException{
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        String email = token.getPrincipal().getAttributes().get("email").toString();
        if(userRepo.findUserByEmail(email).isPresent()){

        }
        else{
            User user = new User();
            user.setUsername(token.getPrincipal().getAttributes().get("given_name").toString());
            user.setEmailid(email);
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepo.findById(2).get());
            user.setRoles(roles);
            userRepo.save(user);
        }
        redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse,"/");
    }
}
