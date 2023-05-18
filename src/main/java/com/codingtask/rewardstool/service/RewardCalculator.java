package com.codingtask.rewardstool.service;

public class RewardCalculator {
    private static final double POINTS_THRESHOLD_1 = 50.0;
    private static final double POINTS_THRESHOLD_2 = 100.0;
    private static final int POINTS_RATE_1 = 1;
    private static final int POINTS_RATE_2 = 2;

    public static int calculateRewardPoints(double purchaseAmount) {
        double amountOverThreshold1 = Math.max(0, purchaseAmount - POINTS_THRESHOLD_1);
        double amountOverThreshold2 = Math.max(0, purchaseAmount - POINTS_THRESHOLD_2);

        int points1 = (int) (amountOverThreshold1 * POINTS_RATE_1);
        int points2 = (int) (amountOverThreshold2 * POINTS_RATE_2);

        return points1 + points2;
    }
}
