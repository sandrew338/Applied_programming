import java.util.Objects;

public class BankAccount {
    private final String accountNumber;
    private final String currency;
    private double balance;

    public BankAccount(String accountNumber, String currency, double initialBalance) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BankAccount that = (BankAccount) o;
//        return Double.compare(balance, that.balance) == 0 && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(currency, that.currency);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(accountNumber, currency, balance);
//    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Not enough money.");
        }
        balance -= amount;
    }
}