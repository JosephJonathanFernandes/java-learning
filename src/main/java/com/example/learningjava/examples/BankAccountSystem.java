package com.example.learningjava.examples;

import com.example.learningjava.model.Account;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankAccountSystem {
  private static final Logger LOGGER = Logger.getLogger(BankAccountSystem.class.getName());

  // Menu options
  private static final int DEPOSIT_OPTION = 1;
  private static final int WITHDRAW_OPTION = 2;
  private static final int VIEW_BALANCE_OPTION = 3;
  private static final int EXIT_OPTION = 4;

  // Configuration
  private static final String CURRENCY_SYMBOL = "₹";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      System.out.print("Enter account holder name: ");
      String name = sc.nextLine();
      System.out.print("Enter initial deposit: ");
      double deposit = sc.nextDouble();
      sc.nextLine(); // consume newline

      Account acc = new Account(name, deposit);

      int choice;
      do {
        System.out.println("\n--- Bank Menu ---");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View Balance");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
        while (!sc.hasNextInt()) {
          System.out.println("Invalid input. Please enter a number.");
          sc.next();
        }
        choice = sc.nextInt();
        sc.nextLine(); // consume newline

        try {
          switch (choice) {
            case DEPOSIT_OPTION:
              System.out.print("Enter amount: ");
              double amt = sc.nextDouble();
              sc.nextLine();
              acc.deposit(amt);
              LOGGER.info("Deposited: " + amt);
              break;
            case WITHDRAW_OPTION:
              System.out.print("Enter amount: ");
              amt = sc.nextDouble();
              sc.nextLine();
              acc.withdraw(amt);
              LOGGER.info("Withdrawn: " + amt);
              break;
            case VIEW_BALANCE_OPTION:
              System.out.println("\nAccount Holder: " + acc.getHolderName());
              System.out.println("Balance: " + CURRENCY_SYMBOL + acc.getBalance());
              break;
            case EXIT_OPTION:
              System.out.println("Goodbye!");
              break;
            default:
              System.out.println("Invalid choice!");
              break;
          }
        } catch (IllegalArgumentException e) {
          LOGGER.log(Level.WARNING, e.getMessage());
          System.out.println("Error: " + e.getMessage());
        }

      } while (choice != EXIT_OPTION);

    } catch (InputMismatchException e) {
      LOGGER.log(Level.SEVERE, "Invalid input type.", e);
      System.out.println("Invalid input. Exiting.");
    } finally {
      sc.close();
    }
  }
}
