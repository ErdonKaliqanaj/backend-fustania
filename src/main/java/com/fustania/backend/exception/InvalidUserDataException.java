package com.fustania.backend.exception;

public class InvalidUserDataException extends RuntimeException{
    public InvalidUserDataException(String message){
        super(message);
    }

}
