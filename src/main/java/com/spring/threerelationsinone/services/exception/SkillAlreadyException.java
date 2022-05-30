package com.spring.threerelationsinone.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SkillAlreadyException extends RuntimeException {
    @Override
    public String getMessage() {

        return super.getMessage();
    }
}
