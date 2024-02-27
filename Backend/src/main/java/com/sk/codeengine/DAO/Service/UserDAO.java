package com.sk.codeengine.DAO.Service;


import com.sk.codeengine.DTO.LoginDTO;
import com.sk.codeengine.DTO.SignUpDTO;
import com.sk.codeengine.Model.UserModel;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface UserDAO {


    Optional<UserModel> findByEmail(String username);

    boolean isUserExist(String email);

    UserModel createUser(SignUpDTO signUpDTO);

    Optional<UserModel> findUserById(Long id);
}
