import java.util.*;

import Account.Account;
import Bank.Bank;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            int choice;

            while (true) {
                System.out.println("Choose an option:");
                System.out.println("Press 1. Create a new account");
                System.out.println("Press 2. Display all accounts");
                System.out.println("Press 3. Update an account");
                System.out.println("Press 4. Delete an account");
                System.out.println("Press 5. Deposit an amount into your account");
                System.out.println("Press 6. Withdraw an amount from your account");
                System.out.println("Press 7. Search for account");
                System.out.println("Press 8. Exit");
                try {  
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Enter a valid choice.");
                }
            }

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    displayAccounts();
                    break;
                case 3:
                    updateAccount();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    deposit();
                    break;
                case 6:
                    withdraw();
                    break;
                case 7:
                    searchForAccount();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                    break;
            }
        }
    }

    private static void createAccount() {
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();

        String type = "";

        while (true) { //to ensure that an user chooses a correct account type
            System.out.println("Enter Account Type (current/saving/salary):");
            type = scanner.nextLine().toLowerCase();

            if (type.equals("current") || type.equals("saving") || type.equals("salary")) {
                break;
            } else {
                System.out.println("Enter a valid account type.");
            }
        }

        double initialDeposit;

        while (true) { // to make sure that an user gives a valid amount as input
            System.out.println("Enter Initial Deposit: ");
            try {
                initialDeposit = Double.parseDouble(scanner.nextLine());
                if(initialDeposit <= 0) {
                    System.out.println("Enter a valid amount.");
                }
                else break;
            } catch (Exception e) {
                System.out.println("Enter a valid amount.");
            }
        }

        Account account = bank.createAccount(name, type, initialDeposit);
        if (account != null) {
            System.out.println("Account created successfully. Account Number: " + account.getAccountNumber());
        } else {
            System.out.println("Failed to create account.");
        }
    }

    private static void displayAccounts() {
        List<Account> accounts = bank.getAccounts();

        if(accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for(Account account: accounts) {
                System.out.println(account.getDetails());
            }
        }
    }

    private static void updateAccount() {
        int accountNumber;

        while (true) {
            try {
                System.out.println("Enter account number to update: ");
                accountNumber = Integer.parseInt(scanner.nextLine());
                break; 
            } catch (Exception e) {
                System.out.println("Enter a valid account number");
            }
        }
        
        Account account = bank.findAccount(accountNumber);

        if(account == null) {
            System.out.println("Account not found");
            return;
        } 

        System.out.println("Enter new name:");
        account.setName(scanner.nextLine());
        System.out.println("Account updated successfully.");
    }

    private static void deleteAccount() {
        int accountNumber;

        while (true) {
            try {
                System.out.println("Enter the account number to delete: ");
                accountNumber = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Enter a valid account number.");
            }
        }

        if(bank.deleteAccount(accountNumber)) {
            System.out.println("Account deleted successfully");
        } else {
            System.out.println("Bank not found");
        }
    }

    private static void deposit() {
        int accountNumber;

        while (true) {
            try {
                System.out.println("Enter the account number: ");
                accountNumber = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Enter a valid account number.");
            }
        }

        double amount;

        while (true) {
            System.out.println("Enter deposit amount: ");
            try {
                amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0) {
                    System.out.println("Emter s positive number to deposit.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Enter a valid amount.");
            }
        }

        Account account = bank.findAccount(accountNumber);
        if(account == null) {
            System.out.println("Account not found");
            return;
        }

        account.deposit(amount);
        System.out.println("Amount deposited successfully. New Balance: " + account.getBalance());
    }

    private static void withdraw() {

    }

    private static void searchForAccount() {

    }
}
