package com.codingtask.rewardstool.controller;

import com.codingtask.rewardstool.model.Transaction;
import com.codingtask.rewardstool.service.TransactionService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<List<Transaction>> getTransactionsByCustomerId(@PathVariable String customerId) {
        List<Transaction> getTransactions = transactionService.getTransactionsByCustomerId(customerId);
        return new ResponseEntity<>(getTransactions, HttpStatus.OK);
    }
    @PutMapping("/{transactionId}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable String transactionId, @RequestBody Transaction updatedTransaction) throws ChangeSetPersister.NotFoundException {
        Transaction updated = transactionService.updateTransaction(transactionId, updatedTransaction);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }




}
