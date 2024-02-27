package com.sk.codeengine.Api;


import com.sk.codeengine.DTO.LoginDTO;
import com.sk.codeengine.DTO.SignUpDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/codeEngine/v1/user")
public interface UserApiController {
    @PostMapping("/signup")
    ResponseEntity<?> signupUser(@RequestBody SignUpDTO signUpDTO);

    @PostMapping("/login")
    ResponseEntity<?> userLogin(@RequestBody LoginDTO loginDTO);
}
