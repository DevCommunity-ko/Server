package com.devko.magnet.exception.annotation;

import com.devko.magnet.exception.validator.JobValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = JobValidator.class)
public @interface CheckJob {
    String message() default "No Such a Job";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
