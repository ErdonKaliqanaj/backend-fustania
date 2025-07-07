package com.fustania.backend.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = StrongPasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {
     String message() default "Password must be 8+ characters and contain at least 1 number, 1 uppercase, and 1 lowercase character";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
