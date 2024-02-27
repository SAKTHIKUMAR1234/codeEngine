package com.sk.codeengine.Service.Implementation;


import com.sk.codeengine.DAO.Service.UserDAO;
import com.sk.codeengine.Model.UserModel;
import com.sk.codeengine.Service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServicesImplementation implements UserServices {

    private final UserDAO userDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> userEntityOptional = userDAO.findByEmail(username);
        if(userEntityOptional.isEmpty()){
            throw new UsernameNotFoundException("User Not Exist");
        }

        return userEntityOptional.get();
    }
}
