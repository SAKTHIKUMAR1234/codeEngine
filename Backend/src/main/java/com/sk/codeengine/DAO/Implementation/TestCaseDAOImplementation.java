package com.sk.codeengine.DAO.Implementation;


import com.sk.codeengine.DAO.Repo.TestCaseModelRepo;
import com.sk.codeengine.DAO.Service.TestCaseDAO;
import com.sk.codeengine.Model.TestCaseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestCaseDAOImplementation implements TestCaseDAO {
    private final TestCaseModelRepo testCaseModelRepo;
    @Override
    public Optional<TestCaseModel> findTestCaseById(Long id) {
        return testCaseModelRepo.findById(id);
    }
    @Override
    public TestCaseModel saveTestCase(TestCaseModel testCaseModel) {
        return testCaseModelRepo.save(testCaseModel);
    }
}
