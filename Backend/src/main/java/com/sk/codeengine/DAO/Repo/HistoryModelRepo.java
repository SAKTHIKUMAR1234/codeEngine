package com.sk.codeengine.DAO.Repo;

import com.sk.codeengine.Model.HistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HistoryModelRepo extends JpaRepository<HistoryModel,Long> {
}
