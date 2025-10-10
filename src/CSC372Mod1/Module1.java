package CSC372Mod1;

public class Module1 {
    public static void main(String[] args) {
        // create a BankAccount
        BankAccount bankAccount = new BankAccount("Mike", "Brownley", 55789);
        bankAccount.deposit(850);
        System.out.println("Bank Account Summary:");
        bankAccount.accountSummary();
        bankAccount.withdrawal(275);
        System.out.println("\nAfter withdrawal of $275:");
        bankAccount.accountSummary();
        
        System.out.println("\n-----------------------");
        
        // create a CheckingAccount
        CheckingAccount checkingAccount = new CheckingAccount("Maria", "Garcia", 11223, 3.75);
        checkingAccount.deposit(200);
        System.out.println("\nChecking Account Summary:");
        checkingAccount.displayAccount();
        checkingAccount.processWithdrawal(300); // will trigger overdraft
        System.out.println("\nAfter withdrawal of $300:");
        checkingAccount.displayAccount();
    }
}
