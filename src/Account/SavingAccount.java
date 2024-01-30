package Account;

public class SavingAccount extends Account{
    public SavingAccount(String name, int accountNumber, double initialDeposit) {
        super(name, accountNumber, initialDeposit, 500.0); // by default minimum balance for the saving account is 500.
    }
}
