package com.sk.codeengine.DAO.Repo;

import com.sk.codeengine.Model.TestCaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestCaseModelRepo extends JpaRepository<TestCaseModel,Long> {
}
