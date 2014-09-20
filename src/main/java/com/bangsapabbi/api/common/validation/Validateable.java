package com.bangsapabbi.api.common.validation;

import java.util.Set;
import javax.validation.ConstraintViolation;

public interface Validateable<T> {

    /**
     * Method to validate if we have the basic information needed to add item.
     * @return
     */
    boolean isValidForPost();

    Set<ConstraintViolation<T>> getConstraintViolations();

    String getViolationsAsString();
}