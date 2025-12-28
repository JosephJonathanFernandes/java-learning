package com.example.learningjava.model;

import com.example.learningjava.exceptions.InsufficientBalanceException;
import com.example.learningjava.service.AccountService;

public class SavingsAccount extends Account implements AccountService {

  @Override
  public void calculateInterest() {
    balance += balance * 0.04;
  }

  @Override
  public void deposit(double amount) {
    super.deposit(amount);
  }

  @Override
  public void withdraw(double amount) throws InsufficientBalanceException {
    if (amount > balance) {
      throw new InsufficientBalanceException("Not enough money!");
    }
    balance -= amount;
  }
}
