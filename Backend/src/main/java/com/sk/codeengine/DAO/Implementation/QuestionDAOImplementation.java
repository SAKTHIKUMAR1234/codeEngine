package com.sk.codeengine.DAO.Implementation;


import com.sk.codeengine.DAO.Repo.QuestionModelRepo;
import com.sk.codeengine.DAO.Service.QuestionDAO;
import com.sk.codeengine.Model.QuestionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionDAOImplementation implements QuestionDAO {

    private final QuestionModelRepo questionModelRepo;
    @Override
    public Optional<QuestionModel> findQuestionById(String id) {
        return questionModelRepo.findByQuestionId(id);
    }
    @Override
    public QuestionModel saveQuestion(QuestionModel questionModel) {
        return questionModelRepo.save(questionModel);
    }
}
