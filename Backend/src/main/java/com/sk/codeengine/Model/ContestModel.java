package com.sk.codeengine.Model;


import com.sk.codeengine.Model.Enum.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ContestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserModel host;

    private String contestName;

    private String contestSummary;

    @Column(unique = true)
    private String contestId;

    @ManyToMany
    private List<UserModel> attendeesList;

    private Timestamp startTime;

    private Timestamp endTime;

    private StatusEnum status;

    @OneToMany
    private List<QuestionModel> questionList;

    @CreatedDate
    private Timestamp createdAt;

    @LastModifiedDate
    private Timestamp modifiedAt;
}
