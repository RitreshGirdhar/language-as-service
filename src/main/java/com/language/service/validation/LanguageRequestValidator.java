package com.language.service.validation;

import com.language.service.model.LanguageRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LanguageRequestValidator implements ConstraintValidator<ValidRequest, LanguageRequest> {

    private static final String REQUEST_PATTERN = "%(\\w+)\\s+(.*)";

    @Override
    public boolean isValid(LanguageRequest request, ConstraintValidatorContext context) {
        if (request == null) return true;
        if (request.getCode() == null || request.getCode().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Request code is required")
                    .addPropertyNode("code")
                    .addConstraintViolation();
            return false;
        }

        if (!matchesRequestPatternTest(request.getCode())) {
            context.buildConstraintViolationWithTemplate("Invalid request code format. " +
                    "Your code should follow the given format " +
                    "%language code")
                    .addPropertyNode("code");
            return false;
        }

        return true;
    }

    boolean matchesRequestPatternTest(String code) {
        if (code == null) return false;
        return code.matches(REQUEST_PATTERN);
    }
}
