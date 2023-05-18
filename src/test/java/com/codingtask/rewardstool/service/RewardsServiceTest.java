package com.codingtask.rewardstool.service;

import com.codingtask.rewardstool.model.MonthlyReward;
import com.codingtask.rewardstool.model.RewardResponse;
import com.codingtask.rewardstool.model.TotalPointsResponse;
import com.codingtask.rewardstool.model.Transaction;
import com.codingtask.rewardstool.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RewardsServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    private RewardsService rewardsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        rewardsService = new RewardsService(transactionRepository);
    }

    @Test
    void testCalculateMonthlyRewards() {
        // Mock data
        String customerId = "123";
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("1", customerId, 120, LocalDate.of(2023, 1, 1)));  // January 2023, 90 points
        transactions.add(new Transaction("2", customerId, 80, LocalDate.of(2023, 2, 15)));  // February 2023, 30 points
        transactions.add(new Transaction("3", customerId, 70, LocalDate.of(2023, 2, 20)));  // February 2023, 20 points
        transactions.add(new Transaction("4", customerId, 200, LocalDate.of(2023, 3, 10))); // March 2023, 200 points

        // Mock repository method
        when(transactionRepository.findByCustomerId(customerId)).thenReturn(transactions);

        // Call the calculateMonthlyRewards method
        RewardResponse rewardResponse = rewardsService.calculateMonthlyRewards(customerId);

        // Assertion
        assertEquals(customerId, rewardResponse.getCustomerId());
        assertEquals(3, rewardResponse.getRewards().size());
        assertEquals("January", rewardResponse.getRewards().get(0).getMonth());
        assertEquals(90, rewardResponse.getRewards().get(0).getRewardPoints());
        assertEquals("February", rewardResponse.getRewards().get(1).getMonth());
        assertEquals(50, rewardResponse.getRewards().get(1).getRewardPoints());
        assertEquals("March", rewardResponse.getRewards().get(2).getMonth());
        assertEquals(200, rewardResponse.getRewards().get(2).getRewardPoints());
    }

    @Test
    void testCalculateTotalRewards() {
        // Mock data
        String customerId = "123";
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("1", customerId, 120, LocalDate.of(2023, 1, 1)));  // 90 points
        transactions.add(new Transaction("2", customerId, 80, LocalDate.of(2023, 2, 15)));  // 30 points
        transactions.add(new Transaction("3", customerId, 70, LocalDate.of(2023, 2, 20)));  // 20 points
        transactions.add(new Transaction("4", customerId, 200, LocalDate.of(2023, 3, 10))); // 200 points

        // Mock repository method
        when(transactionRepository.findByCustomerId(customerId)).thenReturn(transactions);

        // Call the calculateTotalRewards method
        TotalPointsResponse totalPointsResponse = rewardsService.calculateTotalRewards(customerId);

        // Assertion
        assertEquals(customerId, totalPointsResponse.getCustomerId());
        assertEquals(340, totalPointsResponse.getTotalPoints());
    }
}
