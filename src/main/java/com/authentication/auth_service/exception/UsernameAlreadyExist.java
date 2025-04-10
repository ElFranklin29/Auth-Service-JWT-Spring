package com.authentication.auth_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsernameAlreadyExist extends RuntimeException{

    public UsernameAlreadyExist (String message){
        super(message);
    }


}
