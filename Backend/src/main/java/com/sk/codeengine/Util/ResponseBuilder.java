package com.sk.codeengine.Util;


import com.sk.codeengine.DTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ResponseBuilder {

    public ResponseEntity<?> getResponse(Object data, HttpStatus httpStatus,String message){

        ResponseDTO responseDTO = ResponseDTO.builder()
                .message(message)
                .data(data)
                .httpStatus(httpStatus.getReasonPhrase())
                .build();
        return new ResponseEntity<>(responseDTO,httpStatus);
    }


}
