package com.brito.carro.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class objectNotFoundException extends RuntimeException {
    public objectNotFoundException(String message) {
        super(message);
    }

    public objectNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
