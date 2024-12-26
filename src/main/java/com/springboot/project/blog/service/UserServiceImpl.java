package com.springboot.project.blog.service;

import com.springboot.project.blog.dto_data_transfer_object.UserDto;
import com.springboot.project.blog.model.User;
import com.springboot.project.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
    }

//    @Override
//    public void registerUser(User user) {
//
//    }

    @Override
    public void saveUser(User user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists!");
        }

        userRepository.save(user);  // Calls the repository to save the user
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);  // Retrieve user by ID
    }

    @Override
    public void registerUser(UserDto userDto) {
        // Convert UserDto to User
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword()); // Encrypt password here if needed
        user.setEmail(userDto.getEmail());

        // Save the user to the repository
        userRepository.save(user); // Save user to the database
    }

    public String loginUser(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!userDto.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return "Login successful for user: " + user.getUsername();
    }

//    @Override
//    public void registerUser(User user) {
//        // Encrypt password
//        user.setPassword((user.getPassword()));
//
//        // Save the user to the database
//        userRepository.save(user);
//    }

//    @Override
//    public boolean authenticateUser(LoginRequest loginRequest) {
//        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());
//        return userOptional.isPresent() && userOptional.get().getPassword().equals(loginRequest.getPassword());
//    }
//
//    public boolean authenticateUser(LoginRequest loginRequest) {
//        User user = userRepository.findByUsername(loginRequest.getUsername());
//
//        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//            return true;
//        }
//
//        return false;
//    }


}
