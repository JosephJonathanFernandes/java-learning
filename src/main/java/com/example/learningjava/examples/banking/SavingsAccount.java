package com.example.learningjava.examples.banking;

public class SavingsAccount extends Account implements AccountService {

  public SavingsAccount() {
    super("Savings", 0.0);
  }

  @Override
  public void calculateInterest() {
    balance += balance * 0.04;
  }

  @Override
  public void deposit(double amount) {
    super.deposit(amount);
  }

  @Override
  public void withdraw(double amount) {
    if (amount > balance) {
      throw new IllegalArgumentException("Not enough money!");
    }
    balance -= amount;
  }

  @Override
  public void transfer(Account from, Account to, double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Transfer amount must be positive");
    }
    try {
      from.withdraw(amount);
      to.deposit(amount);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Insufficient balance", e);
    }
  }
}
