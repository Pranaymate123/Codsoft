package Task3;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public String deposit(double amount) {
        this.balance += amount;
        return "Deposited $" + amount + ". New balance: $" + this.balance;
    }

    public String withdraw(double amount) {
        if (amount > this.balance) {
            return "Insufficient funds";
        }
        this.balance -= amount;
        return "Withdrew $" + amount + ". New balance: $" + this.balance;
    }

    public String checkBalance() {
        return "Current balance: $" + this.balance;
    }
}

public class ATMConsoleApp {
    private static BankAccount userAccount;
    private static Scanner scanner;

    public static void main(String[] args) {
        userAccount = new BankAccount(1000); // Initial balance $1000
        scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(userAccount.withdraw(withdrawAmount));
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(userAccount.deposit(depositAmount));
                    break;
                case 3:
                    System.out.println(userAccount.checkBalance());
                    break;
                case 4:
                    System.out.println("Exiting the ATM. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Select an option (1-4): ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }
}
