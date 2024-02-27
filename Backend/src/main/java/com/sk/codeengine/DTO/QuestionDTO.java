package com.sk.codeengine.DTO;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionDTO {
    private String questionId;
    private String questionName;
    private String questionDesc;
    private List<TestCaseDTO> testCaseList;
}
