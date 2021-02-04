package utcluj.ro.ssatr.Bank1.sim;

public class BankAccount {

    private String owner;
    private int balance;

    BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;  
    }
  
    public String getOwner() { 
        return owner;
    }

    public int getBalance() {
        return balance;
    }
   
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
 