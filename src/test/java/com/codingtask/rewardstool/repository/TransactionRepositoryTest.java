package com.codingtask.rewardstool.repository;

import com.codingtask.rewardstool.model.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Test
    void testFindByCustomerId() {
        // Mock data
        String customerId = "123";
        Transaction transaction1 = new Transaction("1", customerId, 100, LocalDate.now());
        Transaction transaction2 = new Transaction("2", customerId, 200, LocalDate.now());
        List<Transaction> expectedTransactions = Arrays.asList(transaction1, transaction2);

        // Mock repository method
        when(transactionRepository.findByCustomerId(customerId)).thenReturn(expectedTransactions);

        // Call the repository method
        List<Transaction> actualTransactions = transactionRepository.findByCustomerId(customerId);

        // Assertion
        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test
    void testFindByDateBetween() {
        // Mock data
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 31);
        Transaction transaction1 = new Transaction("1", "123", 100, LocalDate.of(2022, 2, 1));
        Transaction transaction2 = new Transaction("2", "456", 200, LocalDate.of(2022, 5, 1));
        List<Transaction> expectedTransactions = Arrays.asList(transaction1, transaction2);

        // Mock repository method
        when(transactionRepository.findByDateBetween(startDate, endDate)).thenReturn(expectedTransactions);

        // Call the repository method
        List<Transaction> actualTransactions = transactionRepository.findByDateBetween(startDate, endDate);

        // Assertion
        assertEquals(expectedTransactions, actualTransactions);
    }
}
