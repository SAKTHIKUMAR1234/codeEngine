package com.sk.codeengine.Exception;

public class InvalidLoginCredentialsException extends RuntimeException{
    private final String message;

    public InvalidLoginCredentialsException(String message){
        super(message);
        this.message=message;
    }
    public String toString(){
        return this.message;
    }
}
