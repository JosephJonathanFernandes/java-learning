


package com.example.learningjava.examples;

import com.example.learningjava.model.Account;
import com.example.learningjava.model.SavingsAccount;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankAccountSystem {
    private static final Logger logger = Logger.getLogger(BankAccountSystem.class.getName());

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
                        case 1 -> {
                            System.out.print("Enter amount: ");
                            double amt = sc.nextDouble();
                            sc.nextLine();
                            acc.deposit(amt);
                            logger.info("Deposited: " + amt);
                        }
                        case 2 -> {
                            System.out.print("Enter amount: ");
                            double amt = sc.nextDouble();
                            sc.nextLine();
                            acc.withdraw(amt);
                            logger.info("Withdrawn: " + amt);
                        }
                        case 3 -> {
                            System.out.println("\nAccount Holder: " + acc.getHolderName());
                            System.out.println("Balance: ₹" + acc.getBalance());
                        }
                        case 4 -> System.out.println("Goodbye!");
                        default -> System.out.println("Invalid choice!");
                    }
                } catch (IllegalArgumentException e) {
                    logger.log(Level.WARNING, e.getMessage());
                    System.out.println("Error: " + e.getMessage());
                }

            } while (choice != 4);

        } catch (InputMismatchException e) {
            logger.log(Level.SEVERE, "Invalid input type.", e);
            System.out.println("Invalid input. Exiting.");
        } finally {
            sc.close();
        }
    }
}
