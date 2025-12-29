package com.example.learningjava.examples.banking;

import com.example.learningjava.examples.exceptions.InsufficientBalanceException;

public interface AccountService {

  void deposit(double amount);

  void withdraw(double amount) throws InsufficientBalanceException;

  void transfer(Account from, Account to, double amount);
}
