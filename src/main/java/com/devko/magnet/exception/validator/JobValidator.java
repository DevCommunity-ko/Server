package com.devko.magnet.exception.validator;

import com.devko.magnet.exception.annotation.CheckJob;
import com.devko.magnet.model.enums.Job;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class JobValidator implements ConstraintValidator<CheckJob, String> {

    @Override
    public boolean isValid(String job, ConstraintValidatorContext context) {
        return Arrays.stream(Job.values()).anyMatch(j -> j.name().equals(job));
    }
}
