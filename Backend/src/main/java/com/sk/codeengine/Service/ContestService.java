package com.sk.codeengine.Service;

import com.sk.codeengine.DTO.ContestDTO;
import org.springframework.http.ResponseEntity;

public interface ContestService {
    ResponseEntity<?> createContest(ContestDTO contestDTO);

}
