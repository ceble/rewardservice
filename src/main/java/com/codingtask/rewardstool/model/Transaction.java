package com.codingtask.rewardstool.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;


public class Transaction {
    @Id
    private String transactionId;
    private String customerId;
    private double purchaseAmount;
    private LocalDate date;

    public Transaction(String transactionId, String customerId, double purchaseAmount, LocalDate date) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.purchaseAmount = purchaseAmount;
        this.date = date;
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
