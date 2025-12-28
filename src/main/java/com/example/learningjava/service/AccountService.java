package com.example.learningjava.service;

import com.example.learningjava.exceptions.InsufficientBalanceException;

public interface AccountService {

  void deposit(double amount);

  void withdraw(double amount) throws InsufficientBalanceException;
}
