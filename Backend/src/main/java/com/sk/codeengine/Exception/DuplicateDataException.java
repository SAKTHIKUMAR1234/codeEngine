package com.sk.codeengine.Exception;



public class DuplicateDataException extends RuntimeException{

    private final String message;

    public DuplicateDataException(String message){
        super(message);
        this.message=message;
    }

    public String toString(){
        return this.message;
    }

}
