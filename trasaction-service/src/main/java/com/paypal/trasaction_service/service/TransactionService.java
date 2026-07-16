package com.paypal.trasaction_service.service;

import com.paypal.trasaction_service.entity.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    public Transaction getTransactionById(Long id);

    public List<Transaction> getTransactionsByUser(Long userId);
}
