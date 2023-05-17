package com.codingtask.rewardstool.service;

import com.codingtask.rewardstool.model.MonthlyReward;
import com.codingtask.rewardstool.model.RewardResponse;
import com.codingtask.rewardstool.model.TotalPointsResponse;
import com.codingtask.rewardstool.model.Transaction;
import com.codingtask.rewardstool.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RewardsService {
    private final TransactionRepository transactionRepository;

    public RewardsService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
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
