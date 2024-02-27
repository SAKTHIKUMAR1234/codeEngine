package com.sk.codeengine.Service.Implementation;

import com.sk.codeengine.DAO.Service.UserDAO;
import com.sk.codeengine.DTO.LoginDTO;
import com.sk.codeengine.DTO.SignUpDTO;
import com.sk.codeengine.DTO.TokenDTO;
import com.sk.codeengine.DTO.UserDTO;
import com.sk.codeengine.Exception.DuplicateDataException;
import com.sk.codeengine.Exception.InvalidDataException;
import com.sk.codeengine.Exception.InvalidLoginCredentialsException;
import com.sk.codeengine.Model.UserModel;
import com.sk.codeengine.Service.JwtServices;
import com.sk.codeengine.Service.UserModelService;
import com.sk.codeengine.Util.CodeEnginePhrases;
import com.sk.codeengine.Util.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserModelServiceImplementation implements UserModelService {

    private final UserDAO userDAO;
    private final ResponseBuilder responseBuilder;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtServices jwtServices;

    @Override
    public ResponseEntity<?> userLogin(LoginDTO loginDTO) {
        if(!userDAO.isUserExist(loginDTO.getEmail())) throw new UsernameNotFoundException(CodeEnginePhrases.UsernameNotFoundPhrase);
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),loginDTO.getPassword()));
            UserModel userModel = userDAO.findByEmail(loginDTO.getEmail()).get();
            TokenDTO tokenDTO = TokenDTO.builder()
                    .accessToken(jwtServices.getJwtToken(userModel,""))
                    .refreshToken(jwtServices.getRefreshToken(userModel,""))
                    .build();

            return responseBuilder.getResponse(tokenDTO,HttpStatus.OK,CodeEnginePhrases.UserLoginSuccessPhrase);

        }catch (Exception e){
            throw new InvalidLoginCredentialsException(CodeEnginePhrases.InvalidCredentialsPhrase);
        }
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
            return responseBuilder.getResponse(userDTO, HttpStatus.CREATED, CodeEnginePhrases.DataCreatedPhrase);
        }catch (Exception e){
            throw new InvalidDataException(CodeEnginePhrases.InvalidFormatDataPhrase);
        }

    }

    @Override
    public ResponseEntity<?> getUserData() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<UserModel> userModelOptional = userDAO.findByEmail(email);
        if(userModelOptional.isEmpty()) throw new UsernameNotFoundException(CodeEnginePhrases.UsernameNotFoundPhrase);
        UserModel userModel = userModelOptional.get();
        UserDTO userDTO = UserDTO.builder()
                .email(userModel.getEmail())
                .name(userModel.getName())
                .role(userModel.getRole().name())
                .build();
        return responseBuilder.getResponse(userDTO, HttpStatus.OK, CodeEnginePhrases.DataFetchedSuccessPhrase);

    }
}
