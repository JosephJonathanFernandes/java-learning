package com.example.learningjava.model;

/**
 * Represents a savings account with interest calculation.
 */
public class SavingsAccount extends Account {
    private final double interestRate;

    public SavingsAccount(String name, double deposit, double rate) {
        super(name, deposit);
        this.interestRate = rate;
    }

    public void addInterest() {
        double interest = interestRate / 100 * getBalance();
        deposit(interest);
    }

    public double getInterestRate() {
        return interestRate;
    }
}
