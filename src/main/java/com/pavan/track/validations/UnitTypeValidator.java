package com.pavan.track.validations;

import com.pavan.track.annotations.CheckUnitType;
import com.pavan.track.models.enums.UnitType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UnitTypeValidator implements ConstraintValidator<CheckUnitType, String> {

    @Override
    public void initialize(CheckUnitType constraintAnnotation) { }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isEmpty()){
            return false;
        }
        for(UnitType e : UnitType.values()){
            if(e.getType().equals(value)){
                return true;
            }
        }
        return false;
    }
}
