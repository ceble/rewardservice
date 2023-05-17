package com.codingtask.rewardstool.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.codingtask.rewardstool.model.MonthlyReward;
import com.codingtask.rewardstool.model.RewardResponse;
import com.codingtask.rewardstool.model.TotalPointsResponse;
import com.codingtask.rewardstool.model.Transaction;
import com.codingtask.rewardstool.repository.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByCustomerId(String customerId) {
        return transactionRepository.findByCustomerId(customerId);
    }

    public Transaction updateTransaction(String transactionId, Transaction updatedTransaction) throws ChangeSetPersister.NotFoundException {
        Transaction existingTransaction = transactionRepository.findById(transactionId)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        BeanUtils.copyProperties(updatedTransaction, existingTransaction, "id", "customerId");

        return transactionRepository.save(existingTransaction);
    }

    public List<Transaction> getTransactionsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return transactionRepository.findByDateBetween(startDate, endDate);
    }

    public RewardResponse calculateMonthlyRewards(String customerId) {
        List<Transaction> transactions = transactionRepository.findByCustomerId(customerId);
        List<MonthlyReward> monthlyRewards = new ArrayList<>();
        // Logic to calculate monthly rewards based on the transactions

        // Dummy data for illustration
        monthlyRewards.add(new MonthlyReward("2023", "January", 50));
        monthlyRewards.add(new MonthlyReward("2023", "February", 75));
        monthlyRewards.add(new MonthlyReward("2023", "March", 100));

        return new RewardResponse(customerId, monthlyRewards);
    }

    public TotalPointsResponse calculateTotalRewards(String customerId) {
        List<Transaction> transactions = transactionRepository.findByCustomerId(customerId);
        int totalPoints = 0;
        // Logic to calculate total rewards based on the transactions

        // Dummy data for illustration
        totalPoints = 300;

        return new TotalPointsResponse(customerId, totalPoints);
    }
}
