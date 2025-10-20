import java.util.Scanner;

class Account {
    private String holderName;
    private double balance;

    Account(String name, double initialDeposit) {
        this.holderName = name;
        this.balance = initialDeposit;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        } else System.out.println("Invalid amount!");
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else System.out.println("Insufficient funds or invalid amount!");
    }

    void display() {
        System.out.println("\nAccount Holder: " + holderName);
        System.out.println("Balance: ₹" + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String name, double deposit, double rate) {
        super(name, deposit);
        this.interestRate = rate;
    }

    void addInterest() {
        double interest = interestRate / 100 * getBalance();
        deposit(interest);
        System.out.println("Interest added: ₹" + interest);
    }

    private double getBalance() {
        // Reflection of encapsulation; we access balance through methods, not directly.
        return 0; // For simplicity, pretend this gets balance (we’ll fix this later with getter).
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial deposit: ");
        double deposit = sc.nextDouble();

        Account acc = new Account(name, deposit);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount: ");
                    acc.deposit(sc.nextDouble());
                }
                case 2 -> {
                    System.out.print("Enter amount: ");
                    acc.withdraw(sc.nextDouble());
                }
                case 3 -> acc.display();
                case 4 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
