package com.springboot.project.blog.service;

import com.springboot.project.blog.dto_data_transfer_object.UserDto;
import com.springboot.project.blog.model.User;

public interface UserService {
//    void registerUser(User user);

    void saveUser(User user);
    User getUserById(Long id);


    void registerUser(UserDto userDto);


    String loginUser(UserDto user);

}
