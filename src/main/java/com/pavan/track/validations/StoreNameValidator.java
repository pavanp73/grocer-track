package com.pavan.track.validations;

import com.pavan.track.annotations.CheckStoreName;
import com.pavan.track.models.enums.Store;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StoreNameValidator implements ConstraintValidator<CheckStoreName, String> {

    @Override
    public void initialize(CheckStoreName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isEmpty()){
            return false;
        }
        for(Store store : Store.values()){
            if(store.getStoreName().equals(value)){
                return true;
            }
        }
        return false;
    }
}
