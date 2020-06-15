package com.pavan.track.validations;

import com.pavan.track.annotations.NotNullOrBlank;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullOrBlankValidator implements ConstraintValidator<NotNullOrBlank, String> {

    @Override
    public void initialize(NotNullOrBlank constraintAnnotation) { }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty();
    }
}
