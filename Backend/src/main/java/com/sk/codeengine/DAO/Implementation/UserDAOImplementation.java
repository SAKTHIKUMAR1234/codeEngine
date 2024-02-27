package com.sk.codeengine.DAO.Implementation;

import com.sk.codeengine.DAO.Repo.UserModelRepo;
import com.sk.codeengine.DAO.Service.UserDAO;
import com.sk.codeengine.DTO.LoginDTO;
import com.sk.codeengine.DTO.SignUpDTO;
import com.sk.codeengine.Model.Enum.RoleEnum;
import com.sk.codeengine.Model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserDAOImplementation implements UserDAO {

    private final UserModelRepo userModelRepo;
    @Override
    public Optional<UserModel> findByEmail(String username) {
        return userModelRepo.findByEmail(username);
    }
    @Override
    public boolean isUserExist(String email) {
        return userModelRepo.findByEmail(email).isPresent();
    }
    @Override
    public UserModel createUser(SignUpDTO signUpDTO) {
        UserModel userModel = UserModel.builder()
                .email(signUpDTO.getEmail())
                .role(RoleEnum.USER)
                .password(signUpDTO.getPassword())
                .name(signUpDTO.getName())
                .build();
        return userModelRepo.save(userModel);
    }
    @Override
    public Optional<UserModel> findUserById(Long id) {
        return Optional.empty();
    }
}
