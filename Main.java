import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Console menu for the Bank Account Management System.
 */
public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final List<BankAccount> ACCOUNTS = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = INPUT.nextLine().trim();

            switch (choice) {
                case "1" -> createAccount();
                case "2" -> viewAccounts();
                case "3" -> deposit();
                case "4" -> withdraw();
                case "5" -> running = false;
                default -> System.out.println("Please choose an option from 1 to 5.");
            }
        }

        System.out.println("Thank you for using the Bank Account Management System.");
        INPUT.close();
    }

    private static void printMenu() {
        System.out.println("\n=== Bank Account Management System ===");
        System.out.println("1. Create account");
        System.out.println("2. View accounts");
        System.out.println("3. Deposit money");
        System.out.println("4. Withdraw money");
        System.out.println("5. Exit");
    }

    private static void createAccount() {
        System.out.print("Account holder name: ");
        String name = INPUT.nextLine().trim();

        System.out.print("Account number: ");
        String number = INPUT.nextLine().trim();

        if (findAccount(number) != null) {
            System.out.println("That account number already exists.");
            return;
        }

        double openingBalance = readAmount("Opening balance: $");
        if (openingBalance < 0) {
            System.out.println("Opening balance cannot be negative.");
            return;
        }

        try {
            ACCOUNTS.add(new BankAccount(name, number, openingBalance));
            System.out.println("Account created successfully.");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void viewAccounts() {
        if (ACCOUNTS.isEmpty()) {
            System.out.println("There are no accounts yet.");
            return;
        }

        System.out.println("\n--- Bank Accounts ---");
        for (BankAccount account : ACCOUNTS) {
            System.out.println(account);
        }
    }

    private static void deposit() {
        BankAccount account = requestAccount();
        if (account == null) {
            return;
        }

        double amount = readAmount("Amount to deposit: $");
        try {
            account.deposit(amount);
            System.out.printf("Deposit successful. New balance: $%.2f%n", account.getBalance());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void withdraw() {
        BankAccount account = requestAccount();
        if (account == null) {
            return;
        }

        double amount = readAmount("Amount to withdraw: $");
        try {
            account.withdraw(amount);
            System.out.printf("Withdrawal successful. New balance: $%.2f%n", account.getBalance());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static BankAccount requestAccount() {
        System.out.print("Enter account number: ");
        String number = INPUT.nextLine().trim();
        BankAccount account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
        }
        return account;
    }

    private static BankAccount findAccount(String accountNumber) {
        for (BankAccount account : ACCOUNTS) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    private static double readAmount(String prompt) {
        System.out.print(prompt);
        try {
            return Double.parseDouble(INPUT.nextLine().trim());
        } catch (NumberFormatException exception) {
            System.out.println("Please enter a valid number.");
            return -1;
        }
    }
}
