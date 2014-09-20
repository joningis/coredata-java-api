package com.bangsapabbi.api.common.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Custom javax.validation validator to check uuid's.
 */
public class UUIDValidator implements ConstraintValidator<UUID, String> {

    public static final String UUID_REGEX =
            "[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}";

    @Override
    public void initialize(final UUID constraintAnnotation) {
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        return value != null && value.matches(UUID_REGEX);
    }
}
