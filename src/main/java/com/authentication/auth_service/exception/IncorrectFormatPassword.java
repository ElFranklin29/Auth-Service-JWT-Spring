package com.authentication.auth_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectFormatPassword extends RuntimeException{

    public IncorrectFormatPassword(String message){
        super(message);
    }


}
