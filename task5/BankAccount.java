package task5;
class BankAccount{
    private int accountNumber;
    private int balance;

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println(amount+" "+"amount deposited");
        }
    }
    public void withdraw(double amount){
        if(balance>=amount){
            balance= (int) (balance-amount);
            System.out.println(amount+""+"withdrawn your account"+" "+balance);
        }
        else{
            System.out.println("insufficient balance");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
class Main{
    public static void main(String[] args) {
        BankAccount bn = new BankAccount();
        bn.deposit(2000);
        bn.withdraw(100);
        bn.getAccountNumber();
        System.out.println(bn.getBalance());
    }
}
