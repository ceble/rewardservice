package com.codingtask.rewardstool.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id
    private String transactionId;
    private String customerId;
    private double purchaseAmount;
    private Date date;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
