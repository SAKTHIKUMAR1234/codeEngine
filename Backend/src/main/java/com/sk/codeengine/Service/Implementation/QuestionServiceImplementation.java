package com.sk.codeengine.Service.Implementation;

import com.sk.codeengine.DAO.Service.ContestDAO;
import com.sk.codeengine.DAO.Service.QuestionDAO;
import com.sk.codeengine.DAO.Service.TestCaseDAO;
import com.sk.codeengine.DTO.QuestionDTO;
import com.sk.codeengine.DTO.TestCaseDTO;
import com.sk.codeengine.Exception.InvalidDataException;
import com.sk.codeengine.Model.ContestModel;
import com.sk.codeengine.Model.QuestionModel;
import com.sk.codeengine.Model.TestCaseModel;
import com.sk.codeengine.Service.QuestionService;
import com.sk.codeengine.Util.CodeEnginePhrases;
import com.sk.codeengine.Util.RandomServiceUtility;
import com.sk.codeengine.Util.ResponseBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImplementation implements QuestionService {

    private final ContestDAO contestDAO;
    private final TestCaseDAO testCaseDAO;
    private final QuestionDAO questionDAO;
    private final ResponseBuilder responseBuilder;
    private final RandomServiceUtility randomServiceUtility;

    @Transactional
    @Override
    public ResponseEntity<?> createQuestion(String contestId, QuestionDTO questionDTO) {

        Optional<ContestModel> contestModelOptional = contestDAO.findContestModelByContestId(contestId);
        if(contestModelOptional.isEmpty()) throw new InvalidDataException(CodeEnginePhrases.InvalidContestIdPhrase);
        ContestModel contestModel = contestModelOptional.get();
        List<QuestionModel> questionModelList = contestModel.getQuestionList();
        List<TestCaseDTO> testCaseDTOList = questionDTO.getTestCaseList();
        List<TestCaseModel> testCaseModelList = new ArrayList<>();
        for(TestCaseDTO testCaseDTO:testCaseDTOList){
            if(testCaseDTO.getScore()==0 || testCaseDTO.getOutput().isEmpty()){
                throw new InvalidDataException(CodeEnginePhrases.TestCaseEmptyErrorPhase);
            }
            TestCaseModel testCaseModel = TestCaseModel.builder()
                    .input(testCaseDTO.getInput())
                    .output(testCaseDTO.getOutput())
                    .score(testCaseDTO.getScore())
                    .build();
            testCaseModel = testCaseDAO.saveTestCase(testCaseModel);
            testCaseModelList.add(testCaseModel);
        }
        QuestionModel questionModel = QuestionModel.builder()
                .questionName(questionDTO.getQuestionName())
                .questionDesc(questionDTO.getQuestionDesc())
                .questionId(randomServiceUtility.getRandomId())
                .testCaseList(testCaseModelList)
                .build();
        questionModel = questionDAO.saveQuestion(questionModel);
        questionModelList.add(questionModel);
        contestModel.setQuestionList(questionModelList);
        contestModel = contestDAO.updateContest(contestModel);
        return responseBuilder.getResponse(contestModel, HttpStatus.CREATED,CodeEnginePhrases.QuestionAddSuccessPhase);
    }
}
