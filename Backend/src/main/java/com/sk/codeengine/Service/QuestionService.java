package com.sk.codeengine.Service;

import com.sk.codeengine.DTO.QuestionDTO;
import org.springframework.http.ResponseEntity;

public interface QuestionService {
    ResponseEntity<?> createQuestion(String contestId, QuestionDTO questionDTO);
}
