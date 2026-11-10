public class BankAccount {

    // Private attributes
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber,
                       String accountHolder,
                       double balance) {

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be greater than 0."
            );
        }

        balance += amount;
    }

    // Withdrawal method
    public void withdraw(double amount)
            throws InsufficientFundsException {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be greater than 0."
            );
        }

        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient Funds!"
            );
        }

        balance -= amount;
    }
}
