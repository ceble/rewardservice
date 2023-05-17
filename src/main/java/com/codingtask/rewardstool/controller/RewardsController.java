package com.codingtask.rewardstool.controller;

import com.codingtask.rewardstool.model.RewardResponse;
import com.codingtask.rewardstool.model.TotalPointsResponse;
import com.codingtask.rewardstool.service.RewardsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rewards")
public class RewardsController {
    private final RewardsService rewardsService;

    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @GetMapping("/monthly/{customerId}")
    public ResponseEntity<RewardResponse> getMonthlyRewards(@PathVariable String customerId) {
        RewardResponse rewards = rewardsService.calculateMonthlyRewards(customerId);
        return new ResponseEntity<>(rewards, HttpStatus.OK);
    }

    @GetMapping("/total/{customerId}")
    public ResponseEntity<TotalPointsResponse> getTotalRewards(@PathVariable String customerId) {
        TotalPointsResponse totalPoints = rewardsService.calculateTotalRewards(customerId);
        return new ResponseEntity<>(totalPoints, HttpStatus.OK);
    }
}

