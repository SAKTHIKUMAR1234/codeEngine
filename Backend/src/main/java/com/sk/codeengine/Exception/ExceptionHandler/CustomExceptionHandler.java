package com.sk.codeengine.Exception.ExceptionHandler;

import com.sk.codeengine.Exception.DataNotFoundException;
import com.sk.codeengine.Exception.DuplicateDataException;
import com.sk.codeengine.Exception.InvalidDataException;
import com.sk.codeengine.Util.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
