package com.springboot.project.blog.config;

import com.springboot.project.blog.service.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordValidator.class)  // Link to the validator class
@Target({ ElementType.FIELD, ElementType.METHOD })  // Can be applied to fields or methods
@Retention(RetentionPolicy.RUNTIME)                 // Retained at runtime
public @interface ValidPassword {

    String message() default "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.";

    Class<?>[] groups() default {};  // For grouping constraints

    Class<? extends Payload>[] payload() default {};  // For metadata
}
