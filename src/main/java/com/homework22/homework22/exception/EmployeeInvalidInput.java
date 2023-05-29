package com.homework22.homework22.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeInvalidInput extends RuntimeException{

    public EmployeeInvalidInput() {
    }

    public EmployeeInvalidInput(String message) {
        super(message);
    }

    public EmployeeInvalidInput(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeInvalidInput(Throwable cause) {
        super(cause);
    }

    public EmployeeInvalidInput(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
