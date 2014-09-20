/*
 * Copyright 2014 Azazo
 *
 */
package com.bangsapabbi.api.common;

import java.util.Iterator;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.bangsapabbi.api.common.validation.Validateable;

public abstract class AbstractValidateableDTO<T> implements Validateable<T> {
    @Override
    public boolean isValidForPost() {
        return getConstraintViolations().size() == 0;
    }

    @Override
    public abstract Set<ConstraintViolation<T>> getConstraintViolations();

    protected Set<ConstraintViolation<T>> getConstraintViolations(T value) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();

        return validator.validate(value);
    }

    @Override
    public String getViolationsAsString() {

        StringBuilder violations = new StringBuilder();
        Iterator<? extends ConstraintViolation<?>> iterator
                = this.getConstraintViolations().iterator();
        while (iterator.hasNext()) {
            ConstraintViolation<?> violation = iterator.next();

            violations.append(violation.getPropertyPath().toString())
                    .append(' ')
                    .append(violation.getMessage());

            if(iterator.hasNext()) {
                violations .append("\n");
            }
        }
        return violations.toString();
    }
}
