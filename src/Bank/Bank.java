package Bank;

import java.util.*;

import Account.*;


public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1;

    public Account createAccount(String name, String type, double initialDeposit) {
        Account account = null;

        switch (type.toLowerCase()) { //depending on the user choice of type, an account will be created
            case "saving":
                account = new SavingAccount(name, nextAccountNumber++, initialDeposit);
                break;
            case "current":
                account = new CurrentAccount(name, nextAccountNumber++, initialDeposit);
                break;
            case "salary":
                account = new SalaryAccount(name, nextAccountNumber, initialDeposit);
                break;
            default:
                break;
        }

        if(account != null) {
            accounts.add(account);
        }

        return account;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account findAccount(int accountNumber) {
        for(Account account : accounts) {
            if(account.getAccountNumber() == accountNumber) return account;
        }

        return null;
    }

    public boolean deleteAccount(int accountNumber) {
        return accounts.removeIf(account -> account.getAccountNumber() == accountNumber);
    }
}
