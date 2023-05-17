package com.codingtask.rewardstool.model;

public class MonthlyReward {
    private String year;
    private String month;
    private int rewardPoints;

    public MonthlyReward(String year, String month, int rewardPoints) {
        this.year = year;
        this.month = month;
        this.rewardPoints = rewardPoints;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}


