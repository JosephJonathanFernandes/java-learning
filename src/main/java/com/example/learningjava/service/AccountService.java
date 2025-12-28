package com.example.learningjava.service;

import com.example.learningjava.model.Account;

/**
 * Service for account-related business logic (placeholder for future expansion).
 */
public class AccountService {
    public void transfer(Account from, Account to, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Transfer amount must be positive");
        from.withdraw(amount);
        to.deposit(amount);
    }
}
