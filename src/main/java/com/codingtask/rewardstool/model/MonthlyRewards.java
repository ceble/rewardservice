package com.codingtask.rewardstool.model;

public class MonthlyRewards {
    private int year;
    private int month;
    private int rewardPoints;

    public MonthlyRewards(int year, int month, int rewardPoints) {
        this.year = year;
        this.month = month;
        this.rewardPoints = rewardPoints;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}

