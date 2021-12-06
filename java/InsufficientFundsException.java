class InsufficientFundsException extends Exception {
    double dAmount, balance;

    public InsufficientFundsException(double a, double n) {
        dAmount = n;
        balance = a;
    }

    String excepMesagge() {
        Bank bank = new Bank(balance);

        return "您的取款金额为" + this.dAmount + ",但是账户余额仅为" + bank.show_balance() + ",操作不合法！";
    }
}