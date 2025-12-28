package com.example.learningjava.service;

import com.example.learningjava.exceptions.InsufficientBalanceException;
import com.example.learningjava.model.Account;

public interface AccountService {

  void deposit(double amount);

  void withdraw(double amount) throws InsufficientBalanceException;

  void transfer(Account from, Account to, double amount);
}
