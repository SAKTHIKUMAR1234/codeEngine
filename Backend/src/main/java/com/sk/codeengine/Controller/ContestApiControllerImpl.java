package com.sk.codeengine.Controller;

import com.sk.codeengine.Api.ContestApiController;
import com.sk.codeengine.DTO.ContestDTO;
import com.sk.codeengine.Service.ContestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContestApiControllerImpl implements ContestApiController {

    private final ContestService contestService;
    @Override
    public ResponseEntity<?> getContestList() {
        return null;
    }

    @Override
    public ResponseEntity<?> getContestDetail() {
        return null;
    }

    @Override
    public ResponseEntity<?> createContest(ContestDTO contestDTO) {
        return contestService.createContest(contestDTO);
    }

    @Override
    public ResponseEntity<?> updateContest(ContestDTO contestDTO) {
        return null;
    }
}
