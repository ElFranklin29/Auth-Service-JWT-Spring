package com.authentication.auth_service.exception;

public class NotMatchPassword extends RuntimeException{
    public NotMatchPassword (String message){
        super(message);
    }
}
