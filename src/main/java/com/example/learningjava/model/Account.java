package com.example.learningjava.model;

public abstract class Account {

  protected double balance;

  public void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
    }
  }

  public abstract void calculateInterest();

  public double getBalance() {
    return balance;
  }
}
