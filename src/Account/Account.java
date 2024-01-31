package Account;

import java.time.LocalDate;

public class Account {
    protected String name;
    protected int accountNumber;
    protected LocalDate creationDate;
    protected double balance;
    protected double minimumBalance;

    public Account(String name, int accountNumber, double initialDeposit, double minimumBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.minimumBalance = minimumBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double deposit) {
        balance += deposit;
    }

    public boolean withdraw(double amount) {
        if(balance - amount < minimumBalance) return false; //In case an user crosses the minimum balance for the account.

        balance -= amount;
        return true;
    } 

    public String getDetails() {
        return "Account Number: " + accountNumber + "\nName: " + name + "\nBalance: " + balance + "\n";
    }

    public int getAccountNumber() { //Will be used to identify an account.
        return accountNumber;
    }
}
