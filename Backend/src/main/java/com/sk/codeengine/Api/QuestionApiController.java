package com.sk.codeengine.Api;


import com.sk.codeengine.DTO.QuestionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/codeEngine/v1/question")
public interface QuestionApiController {
    @PostMapping("/create")
    ResponseEntity<?> createQuestion(@RequestParam String contestId, @RequestBody QuestionDTO questionDTO);
}
