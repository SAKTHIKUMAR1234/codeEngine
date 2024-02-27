package com.sk.codeengine.DAO.Service;


import com.sk.codeengine.Model.TestCaseModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TestCaseDAO {

    Optional<TestCaseModel> findTestCaseById(Long id);

    TestCaseModel saveTestCase(TestCaseModel testCaseModel);

}
