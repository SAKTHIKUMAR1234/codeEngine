package com.sk.codeengine.DAO.Implementation;


import com.sk.codeengine.DAO.Repo.ContestModelRepo;
import com.sk.codeengine.DAO.Service.ContestDAO;
import com.sk.codeengine.Model.ContestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContestDAOImplementation implements ContestDAO {

    private final ContestModelRepo contestModelRepo;
    @Override
    public ContestModel contestCreation(ContestModel contestModel) {
        return contestModelRepo.save(contestModel);
    }

    @Override
    public Optional<ContestModel> findContestModelByContestId(String contestId) {
        return contestModelRepo.findByContestId(contestId);
    }

    @Override
    public ContestModel updateContest(ContestModel contestModel) {
        return contestModelRepo.save(contestModel);
    }
}
