package com.devko.magnet.exception.validator;

import com.devko.magnet.exception.annotation.CheckField;
import com.devko.magnet.model.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class FieldValidator implements ConstraintValidator<CheckField, String> {

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return Arrays.stream(Field.values()).anyMatch(f -> f.name().equals(field));
    }
}
