package com.sk.codeengine.DAO.Service;


import com.sk.codeengine.Model.ContestModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ContestDAO {

    ContestModel contestCreation(ContestModel contestModel);

    Optional<ContestModel> findContestModelByContestId(String contestId);

    ContestModel updateContest(ContestModel contestModel);

}
