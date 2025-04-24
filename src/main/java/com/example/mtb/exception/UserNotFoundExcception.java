package com.example.mtb.exception;

import lombok.Getter;

@Getter
public class UserNotFoundExcception extends RuntimeException{
    private String message;

    public UserNotFoundExcception(String message) {
        this.message = message;
    }
}
