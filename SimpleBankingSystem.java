import java.util.Scanner;

// BankAccount class to handle bank account operations
class BankAccount {
    private int accountNumber;
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful! New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Withdraw method with error handling
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful! Remaining Balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Error: Insufficient funds.");
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

// Customer class to manage customer details
class Customer {
    private String name;
    private int customerId;
    private BankAccount account;

    // Constructor
    public Customer(String name, int customerId, int accountNumber, double initialDeposit) {
        this.name = name;
        this.customerId = customerId;
        this.account = new BankAccount(accountNumber, initialDeposit);
    }

    // Display customer details
    public void displayDetails() {
        System.out.println("\n--- Customer Details ---");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + name);
        System.out.println("Account Number: " + account.getAccountNumber());
    }

    public BankAccount getBankAccount() {
        return account;
    }
}

// Main class
public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Customer and Bank Account
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();

        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter Initial Deposit Amount: ");
        double initialDeposit = scanner.nextDouble();

        Customer customer = new Customer(name, customerId, accountNumber, initialDeposit);
        BankAccount account = customer.getBankAccount();

        // Menu-driven system for banking operations
        int choice;
        do {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Show Customer Details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    customer.displayDetails();
                    break;

                case 5:
                    System.out.println("Exiting... Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
