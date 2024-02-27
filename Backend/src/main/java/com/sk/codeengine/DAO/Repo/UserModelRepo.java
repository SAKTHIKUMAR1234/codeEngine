package com.sk.codeengine.DAO.Repo;

import com.sk.codeengine.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserModelRepo extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByEmail(String username);
}
