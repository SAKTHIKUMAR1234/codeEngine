package com.sk.codeengine.DTO;


import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class ContestDTO {

    private String contestName;
    private String contestSummary;
    private String contestId;
    private Timestamp startTime;
    private Timestamp endTime;
    private String status;
    private List<QuestionListDTO> questionList;

}
