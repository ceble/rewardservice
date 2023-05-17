package com.codingtask.rewardstool.model;

public class TotalPointsResponse {
    private String customerId;
    private int totalPoints;

    public TotalPointsResponse(String customerId, int totalPoints) {
        this.customerId = customerId;
        this.totalPoints = totalPoints;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
