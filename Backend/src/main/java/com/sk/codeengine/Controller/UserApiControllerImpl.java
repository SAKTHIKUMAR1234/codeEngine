package com.sk.codeengine.Controller;
import com.sk.codeengine.Api.UserApiController;
import com.sk.codeengine.DTO.LoginDTO;
import com.sk.codeengine.DTO.SignUpDTO;
import com.sk.codeengine.Service.UserModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserApiControllerImpl implements UserApiController {
    private final UserModelService userModelService;
    @Override
    public ResponseEntity<?> signupUser(SignUpDTO signUpDTO) {
        return userModelService.userSignUp(signUpDTO);
    }
    @Override
    public ResponseEntity<?> userLogin(LoginDTO loginDTO) {
        return null;
    }
}
