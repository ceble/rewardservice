package com.codingtask.rewardstool.model;

import java.util.List;

public class RewardResponse {
    private String customerId;
    private List<MonthlyReward> rewards;

    public RewardResponse(String customerId, List<MonthlyReward> rewards) {
        this.customerId = customerId;
        this.rewards = rewards;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<MonthlyReward> getRewards() {
        return rewards;
    }
}
