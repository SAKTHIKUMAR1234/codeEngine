package com.sk.codeengine.Api;


import com.sk.codeengine.DTO.ContestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/codeEngine/v1/contest")
public interface ContestApiController {

    @GetMapping("/list")
    ResponseEntity<?> getContestList();

    @GetMapping("/{id}")
    ResponseEntity<?> getContestDetail();

    @PostMapping("/create")
    ResponseEntity<?> createContest(@RequestBody ContestDTO contestDTO);

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateContest(@RequestBody ContestDTO contestDTO);


}
