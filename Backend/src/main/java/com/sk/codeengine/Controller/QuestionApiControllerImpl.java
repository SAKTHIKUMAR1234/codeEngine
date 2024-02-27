package com.sk.codeengine.Controller;


import com.sk.codeengine.Api.QuestionApiController;
import com.sk.codeengine.DTO.QuestionDTO;
import com.sk.codeengine.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionApiControllerImpl implements QuestionApiController {

    private final QuestionService questionService;
    @Override
    public ResponseEntity<?> createQuestion(String contestId, QuestionDTO questionDTO) {
        return questionService.createQuestion(contestId,questionDTO);
    }
}
