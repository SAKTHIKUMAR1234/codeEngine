package com.sk.codeengine.DAO.Repo;

import com.sk.codeengine.Model.ContestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContestModelRepo extends JpaRepository<ContestModel,Long> {
    Optional<ContestModel> findByContestId(String contestId);
}
