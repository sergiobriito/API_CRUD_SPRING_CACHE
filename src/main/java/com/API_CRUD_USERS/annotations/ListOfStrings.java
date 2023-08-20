package com.API_CRUD_USERS.annotations;

import com.API_CRUD_USERS.utils.ListOfStringsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ListOfStringsValidator.class)
public @interface ListOfStrings {
    String message() default "Each element in the list must be a string";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int value();
}
