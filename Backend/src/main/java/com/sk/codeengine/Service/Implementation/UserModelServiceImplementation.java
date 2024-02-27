package com.sk.codeengine.Service.Implementation;

import com.sk.codeengine.DAO.Service.UserDAO;
import com.sk.codeengine.DTO.LoginDTO;
import com.sk.codeengine.DTO.SignUpDTO;
import com.sk.codeengine.DTO.UserDTO;
import com.sk.codeengine.Exception.DuplicateDataException;
import com.sk.codeengine.Exception.InvalidDataException;
import com.sk.codeengine.Model.UserModel;
import com.sk.codeengine.Service.UserModelService;
import com.sk.codeengine.Util.CodeEnginePhrases;
import com.sk.codeengine.Util.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserModelServiceImplementation implements UserModelService {

    private final UserDAO userDAO;
    private final ResponseBuilder responseBuilder;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> userLogin(LoginDTO loginDTO) {



    }

    @Override
    public ResponseEntity<?> userSignUp(SignUpDTO signUpDTO) {
        if (userDAO.isUserExist(signUpDTO.getEmail())) {
            throw new DuplicateDataException("User Email Already Exist");
        }
        signUpDTO.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        try{
            UserModel userModel = userDAO.createUser(signUpDTO);
            UserDTO userDTO = UserDTO.builder()
                    .email(userModel.getEmail())
                    .name(userModel.getName())
                    .role(userModel.getRole().name())
                    .build();
            return responseBuilder.getResponse(userDTO, HttpStatus.CREATED, CodeEnginePhrases.userCreatedPhrase);
        }catch (Exception e){
            throw new InvalidDataException(e.toString());
        }

    }
}
