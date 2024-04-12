package com.jurgenvrapi.progettoS6D5.exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
public class BadRequest extends RuntimeException {
    private List<ObjectError> errorsList;

    public BadRequest(String message) {
        super(message);
    }

    public BadRequest(List<ObjectError> errorsList) {
        super("Errori nel body");
        this.errorsList = errorsList;
    }

}