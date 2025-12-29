package com.example.learningjava.examples.banking;

public class BankAccountSystem {

  public static void main(String[] args) {

    SavingsAccount acc = new SavingsAccount();

    acc.deposit(1000);
    acc.calculateInterest();

    System.out.println("Final Balance: " + acc.getBalance());
  }
}
