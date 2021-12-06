public class Bank {
    public double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    void deposite(double dAmount) {
        this.balance += dAmount;
    }

    void withdrawal(double dAmount) throws InsufficientFundsException {
        if (dAmount > this.balance) {
            throw new InsufficientFundsException(this.balance, dAmount);
        }
        this.balance -= dAmount;
    }

    double show_balance() {
        return this.balance;
    }
}
