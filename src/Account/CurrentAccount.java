package Account;

public class CurrentAccount extends Account {
    public CurrentAccount(String name, int accountNumber, double initialDeposit) {
        super(name, accountNumber, initialDeposit, 1000.00); //by default minimum balance for the current account is 500.00.
    }
}