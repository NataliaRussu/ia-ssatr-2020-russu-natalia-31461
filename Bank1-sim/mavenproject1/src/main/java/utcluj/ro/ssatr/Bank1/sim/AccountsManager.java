package utcluj.ro.ssatr.Bank1.sim;

public class AccountsManager {

    BankAccount[] accounts = new BankAccount[10];  

    public void addAccount (BankAccount a) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = a;
                System.out.println("New account added on account manager.");
                return;
            }    
        }
        System.out.println("No empty position found on account manager.");
    }
 
    public int getTotalBalance() {
        int totalBalance = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                totalBalance += 0;
            } else {
                totalBalance += accounts[i].getBalance();
            }
        } 
        System.out.println("Total balance is: " + totalBalance);
        return totalBalance;
    }

    public boolean transfer(String fromOwnerName, String toOwnerName, int amount) {
        boolean transfer = false;
        int contor = 0;
        int fromOwnerbalance = 0, toOwnerBalance = 0;
        for (BankAccount account : accounts) {
            if (account != null) {
                if (account.getOwner().equals(fromOwnerName)) {
                    if (account.getBalance() < amount) {
                        return false;
                    } else {
                        fromOwnerbalance = account.getBalance();
                    }
                    System.out.println(account.getOwner() + " initial balance: " + account.getBalance());
                }
                if (account.getOwner().equals(toOwnerName)) {
                    toOwnerBalance = account.getBalance();
                    System.out.println(account.getOwner() + " initial balance: " + account.getBalance());
                }
            }
        }
        for (BankAccount account : accounts) {
            if (account != null) {
                if (account.getOwner().equals(fromOwnerName)) {
                    account.setBalance(fromOwnerbalance - amount);
                    contor = contor + 1;
                    System.out.println(account.getOwner() + " new balance: " + account.getBalance());
                }
                if (account.getOwner().equals(toOwnerName)) {
                    account.setBalance(toOwnerBalance + amount);
                    contor = contor + 1;
                    System.out.println(account.getOwner() + " new balance: " + account.getBalance());
                }
            }
        }
        if (contor == 2) {
            transfer = true;
        }
        return transfer;
    }

}
