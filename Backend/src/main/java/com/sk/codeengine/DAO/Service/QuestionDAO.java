package com.sk.codeengine.DAO.Service;


import com.sk.codeengine.Model.QuestionModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface QuestionDAO {

    Optional<QuestionModel> findQuestionById(String id);
    QuestionModel saveQuestion(QuestionModel questionModel);

}
