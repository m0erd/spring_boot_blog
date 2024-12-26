//package com.springboot.project.blog.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/users/register").permitAll()  // Allow registration without authentication
//                .anyRequest().authenticated()  // All other requests need authentication
//                .and()
//                .formLogin()  // Enable form-based login
//                .permitAll()  // Allow everyone to access the login form
//                .and()
//                .logout()  // Enable logout functionality
//                .permitAll();  // Allow everyone to logout
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
