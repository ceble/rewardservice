package com.codingtask.rewardstool.repository;

import com.codingtask.rewardstool.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "transactions", path = "transactions")
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findByCustomerId(String customerId);
    List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate);
}

