package com.sk.codeengine.Exception;

public class InvalidDataException extends RuntimeException{
    private final String message;
    public InvalidDataException(String message){
        super(message);
        this.message=message;
    }

    public String toString(){
        return message;
    }
}
