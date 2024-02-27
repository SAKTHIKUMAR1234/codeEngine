package com.sk.codeengine.DTO;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class QuestionListDTO {
    private String name;
    private String questionId;
}
