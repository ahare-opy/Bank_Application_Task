package Account;

public class SalaryAccount extends Account {
    public SalaryAccount(String name, int accountNumber, double initialDeposit) {
        super(name, accountNumber, initialDeposit, 0.00); //by default minimum balance for the salary account is 0.00.
    }
}
