package com.sk.codeengine.DTO;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignUpDTO {

    private String name;
    private String email;
    private String password;

}
