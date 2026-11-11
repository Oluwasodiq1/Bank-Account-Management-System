# Bank Account Management System

A small Java console application that demonstrates basic object-oriented programming through simple bank account operations.

## Features
- Create an account with an account holder, account number, and opening balance
- View all accounts created during the current run
- Deposit money
- Withdraw money with an insufficient-funds check
- Validate account details and transaction amounts

## Requirements
- Java 17 or newer

## Compile
Open a terminal in this folder and run:

```bash
javac Main.java BankAccount.java
```

## Run

```bash
java Main
```

## Project structure

```text
Bank-Account-Management-System/
├── BankAccount.java
├── Main.java
└── README.md
```

## Notes
This is an educational console project. Accounts are kept in memory and are not saved after the program exits. It is not connected to a real bank and should not be used for real financial transactions.
