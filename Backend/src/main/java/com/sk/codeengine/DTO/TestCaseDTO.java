package com.sk.codeengine.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCaseDTO {

    private Long testCaseId;
    private String input;
    private String output;
    private Double score;

}
