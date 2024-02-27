package com.sk.codeengine.DAO.Repo;

import com.sk.codeengine.Model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionModelRepo extends JpaRepository<QuestionModel,Long> {
    Optional<QuestionModel> findByQuestionId(String id);

}
