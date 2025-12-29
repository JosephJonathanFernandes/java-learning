package com.example.learningjava.examples.banking;

public class Account {

  protected double balance;

  public Account(String name, double initialBalance) {
    this.balance = initialBalance;
  }

  public void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
    }
  }

  public void withdraw(double amount) {
    if (amount > balance) {
      throw new IllegalArgumentException("Insufficient funds");
    }
    balance -= amount;
  }

  public void calculateInterest() {
    // Default implementation: no interest
  }

  public double getBalance() {
    return balance;
  }
}
