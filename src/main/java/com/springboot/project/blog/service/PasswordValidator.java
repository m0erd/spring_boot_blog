package com.springboot.project.blog.service;

import com.springboot.project.blog.config.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.isBlank()) {
            return false; // Password can't be null or blank
        }

        // Regular expression to enforce password rules:
        // - At least 1 uppercase letter
        // - At least 1 lowercase letter
        // - At least 1 digit
        // - At least 1 special character
        // - Minimum 8 characters long
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$";

        return password.matches(passwordRegex);
    }
}
