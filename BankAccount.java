import java.util.ArrayList;
import java.util.List;

/**
 * Represents a simple bank account.
 */
public class BankAccount {
    private final String accountHolder;
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber, double openingBalance) {
        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException("Account holder name cannot be empty.");
        }
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative.");
        }

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("%s | Account: %s | Balance: $%.2f",
                accountHolder, accountNumber, balance);
    }
}
