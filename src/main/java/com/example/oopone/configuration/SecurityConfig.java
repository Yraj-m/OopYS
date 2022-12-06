//package com.example.oopone.configuration;
//
//import com.example.oopone.configuration.UserDetailServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = false, securedEnabled = true)
//public class SecurityConfig {
//
//    @Autowired
//    UserDetailServiceImpl userDetailService;
//
//
//    public SecurityConfig(UserDetailServiceImpl userDetailService) {
//        this.userDetailService = userDetailService;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().authorizeHttpRequests(authorize -> {
//            try {
//                authorize
//                                .requestMatchers("/").permitAll()
//                                .requestMatchers("/admin/**").hasAuthority("ADMIN")
//                                .requestMatchers("/user/**").hasAuthority("USER")
//                                .anyRequest()
//                                .authenticated()
//                                .and()
//                                .formLogin()
//                                .loginPage("/login")
//                                .permitAll()
//                                .and().csrf().disable()
//                                .logout().permitAll();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//
//        });
//        return http.build();
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
////import com.example.oopone.service.UserDetailServiceImpl;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.http.HttpMethod;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.provisioning.InMemoryUserDetailsManager;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
////@EnableWebSecurity
//////@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
////public class SecurityConfig  {
////
////    @Bean
////    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailService)
////            throws Exception {
////        return http.getSharedObject(AuthenticationManagerBuilder.class)
////                .userDetailsService(userDetailService)
////                .passwordEncoder(bCryptPasswordEncoder)
////                .and()
////                .build();
////    }
////
////    @Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    @Bean
////    public DaoAuthenticationProvider authenticationProvider() {
////
////        DaoAuthenticationProvider authprovider = new DaoAuthenticationProvider();
////        authprovider.setPasswordEncoder(passwordEncoder());
////        authprovider.setUserDetailsService(userDetailsService());
////
////        return authprovider;
////    }
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(authenticationProvider());
////    }
////
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.csrf()
////                .disable()
////                .authorizeHttpRequests()
////                .requestMatchers("/shop")
////                .hasRole("ADMIN")
////                .requestMatchers("/admin/**")
////                .hasAnyRole("ADMIN")
////                .requestMatchers("/user/**")
////                .hasAnyRole("USER", "ADMIN")
////                .requestMatchers("/login/**")
////                .anonymous()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .httpBasic()
////                .and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////
////        return http.build();
////    }
////
////
////}
