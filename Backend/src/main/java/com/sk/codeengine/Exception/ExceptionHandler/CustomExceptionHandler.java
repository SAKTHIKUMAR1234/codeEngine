package com.sk.codeengine.Exception.ExceptionHandler;

import com.sk.codeengine.Exception.DataNotFoundException;
import com.sk.codeengine.Exception.DuplicateDataException;
import com.sk.codeengine.Exception.InvalidDataException;
import com.sk.codeengine.Exception.InvalidLoginCredentialsException;
import com.sk.codeengine.Util.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    private final ResponseBuilder responseBuilder;

    @ExceptionHandler(DuplicateDataException.class)
    public ResponseEntity<?> handleDuplicateDataException(DuplicateDataException duplicateDataException){
        return responseBuilder.getResponse(null, HttpStatus.CONFLICT, duplicateDataException.toString());
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<?> handleInvalidDataException(InvalidDataException invalidDataException){
        return responseBuilder.getResponse(null,HttpStatus.BAD_REQUEST,invalidDataException.toString());
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> handleDataNotFoundException(DataNotFoundException dataNotFoundException){
        return responseBuilder.getResponse(null,HttpStatus.NOT_FOUND,dataNotFoundException.toString());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleUserNameNotFoundException(UsernameNotFoundException usernameNotFoundException){
        return responseBuilder.getResponse(null,HttpStatus.NOT_FOUND, usernameNotFoundException.getMessage());
    }

    @ExceptionHandler(InvalidLoginCredentialsException.class)
    public ResponseEntity<?> handleInvalidLoginCredentialsException(InvalidLoginCredentialsException invalidLoginCredentialsException){
        return responseBuilder.getResponse(null,HttpStatus.UNAUTHORIZED,invalidLoginCredentialsException.toString());
    }
}
