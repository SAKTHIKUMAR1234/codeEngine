package com.sk.codeengine.Service.Implementation;


import com.sk.codeengine.DAO.Service.ContestDAO;
import com.sk.codeengine.DAO.Service.UserDAO;
import com.sk.codeengine.DTO.ContestDTO;
import com.sk.codeengine.DTO.QuestionListDTO;
import com.sk.codeengine.Exception.InvalidDataException;
import com.sk.codeengine.Model.ContestModel;
import com.sk.codeengine.Model.Enum.StatusEnum;
import com.sk.codeengine.Model.QuestionModel;
import com.sk.codeengine.Model.UserModel;
import com.sk.codeengine.Service.ContestService;
import com.sk.codeengine.Util.CodeEnginePhrases;
import com.sk.codeengine.Util.RandomServiceUtility;
import com.sk.codeengine.Util.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContestServiceImplementation implements ContestService {

    private final RandomServiceUtility randomServiceUtility;
    private final UserDAO userDAO;
    private final ContestDAO contestDAO;
    private final ResponseBuilder responseBuilder;


    @Override
    public ResponseEntity<?> createContest(ContestDTO contestDTO) {
        if (contestDTO.getStartTime().before(new Timestamp(System.currentTimeMillis())) || contestDTO.getEndTime().before(new Timestamp(System.currentTimeMillis())) || contestDTO.getEndTime().before(contestDTO.getStartTime()) || contestDTO.getEndTime().equals(contestDTO.getStartTime())) {
            throw new InvalidDataException(CodeEnginePhrases.InvalidFormatDataPhrase);
        }
        try {
            UserModel userModel = userDAO.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get();
            ContestModel contestModel = ContestModel.builder()
                    .contestId(randomServiceUtility.getRandomId())
                    .contestName(contestDTO.getContestName())
                    .contestSummary(contestDTO.getContestSummary())
                    .startTime(contestDTO.getStartTime())
                    .endTime(contestDTO.getEndTime())
                    .attendeesList(new ArrayList<>())
                    .questionList(new ArrayList<>())
                    .status(StatusEnum.PENDING)
                    .host(userModel)
                    .build();
            contestModel = contestDAO.contestCreation(contestModel);

            List<QuestionListDTO> questionListDTO = new ArrayList<>();
//        for(QuestionModel questionModel : contestModel.getQuestionList()){
//            questionListDTO.add(QuestionListDTO.builder()
//                            .name(questionModel.getQuestionName())
//                            .questionId(questionModel.getQuestionId())
//                    .build());
//        }

            contestDTO = ContestDTO.builder()
                    .contestId(contestModel.getContestId())
                    .contestName(contestModel.getContestName())
                    .status(contestModel.getStatus().name())
                    .startTime(contestModel.getStartTime())
                    .endTime(contestModel.getEndTime())
                    .questionList(questionListDTO)
                    .contestSummary(contestModel.getContestSummary())
                    .build();
            return responseBuilder.getResponse(contestDTO, HttpStatus.CREATED, CodeEnginePhrases.DataCreatedPhrase);
        } catch (Exception e) {
            throw new InvalidDataException(CodeEnginePhrases.InvalidFormatDataPhrase);
        }
    }
}
