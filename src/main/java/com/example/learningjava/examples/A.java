package com.example.learningjava.examples;

class Account {
  private double balance = 0;

  public void deposit(double amount) {
    balance += amount;
  }

  public void showBalance() {
    System.out.println("Balance = " + balance);
  }
}
