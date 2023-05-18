package com.codingtask.rewardstool.service;

import com.codingtask.rewardstool.model.MonthlyReward;
import com.codingtask.rewardstool.model.RewardResponse;
import com.codingtask.rewardstool.model.TotalPointsResponse;
import com.codingtask.rewardstool.model.Transaction;
import com.codingtask.rewardstool.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RewardsService {
    private final TransactionRepository transactionRepository;

    public RewardsService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public RewardResponse calculateMonthlyRewards(String customerId) {
        List<Transaction> transactions = transactionRepository.findByCustomerId(customerId);
        List<MonthlyReward> monthlyRewards = new ArrayList<>();

        // Group transactions by year and month
        Map<Integer, Map<String, List<Transaction>>> transactionsByYearAndMonth = transactions.stream()
                .collect(Collectors.groupingBy(transaction -> getYear(transaction.getDate()),
                        Collectors.groupingBy(transaction -> getMonth(transaction.getDate()))));

        // Calculate rewards for each year and month
        for (Integer year : transactionsByYearAndMonth.keySet()) {
            Map<String, List<Transaction>> transactionsByMonth = transactionsByYearAndMonth.get(year);

            for (String month : transactionsByMonth.keySet()) {
                List<Transaction> transactionsInMonth = transactionsByMonth.get(month);

                int totalPoints = 0;
                for (Transaction transaction : transactionsInMonth) {
                    double purchaseAmount = transaction.getPurchaseAmount();
                    int points = calculateRewardPoints(purchaseAmount);
                    totalPoints += points;
                }

                monthlyRewards.add(new MonthlyReward(year.toString(), month, totalPoints));
            }
        }

        return new RewardResponse(customerId, monthlyRewards);
    }


    public TotalPointsResponse calculateTotalRewards(String customerId) {
        List<Transaction> transactions = transactionRepository.findByCustomerId(customerId);
        int totalPoints = 0;

        for (Transaction transaction : transactions) {
            double purchaseAmount = transaction.getPurchaseAmount();
            int points = calculateRewardPoints(purchaseAmount);
            totalPoints += points;
        }

        return new TotalPointsResponse(customerId, totalPoints);
    }

    private int calculateRewardPoints(double purchaseAmount) {
        int rewardPoints = 0;
        if (purchaseAmount > 100) {
            double pointsAbove100 = purchaseAmount - 100;
            rewardPoints += pointsAbove100 * 2;
        }
        if (purchaseAmount > 50) {
            double pointsAbove50 = Math.min(purchaseAmount, 100) - 50;
            rewardPoints += pointsAbove50;
        }
        return rewardPoints;
    }

    private int getYear(LocalDate date) {
        return date.getYear();
    }

    private String getMonth(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMMM"));
    }
}
