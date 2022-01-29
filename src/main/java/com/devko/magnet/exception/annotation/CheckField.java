package com.devko.magnet.exception.annotation;

import com.devko.magnet.exception.validator.FieldValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldValidator.class)
public @interface CheckField {
    String message() default "No Such a Field";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
