package com.codingtask.rewardstool.controller;

import com.codingtask.rewardstool.model.RewardResponse;
import com.codingtask.rewardstool.model.TotalPointsResponse;
import com.codingtask.rewardstool.model.Transaction;
import com.codingtask.rewardstool.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {
    private final TransactionService transactionService;

    public RewardsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transactions")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/monthly/{customerId}")
    public ResponseEntity<RewardResponse> getMonthlyRewards(@PathVariable String customerId) {
        RewardResponse rewards = transactionService.calculateMonthlyRewards(customerId);
        return new ResponseEntity<>(rewards, HttpStatus.OK);
    }

    @GetMapping("/total/{customerId}")
    public ResponseEntity<TotalPointsResponse> getTotalRewards(@PathVariable String customerId) {
        TotalPointsResponse totalPoints = transactionService.calculateTotalRewards(customerId);
        return new ResponseEntity<>(totalPoints, HttpStatus.OK);
    }
}

