package com.sk.codeengine.Service;


import com.sk.codeengine.DTO.LoginDTO;
import com.sk.codeengine.DTO.SignUpDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserModelService {
    ResponseEntity<?> userLogin(LoginDTO loginDTO);
    ResponseEntity<?> userSignUp(SignUpDTO signUpDTO);

}
