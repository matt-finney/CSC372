package CSC372Mod1;

public class Module1 {
    public static void main(String[] args) {
        // create a BankAccount
        BankAccount bankAccount = new BankAccount("John", "Doe", 12345);
        bankAccount.deposit(500);
        System.out.println("Bank Account Summary:");
        bankAccount.accountSummary();
        bankAccount.withdrawal(100);
        System.out.println("\nAfter withdrawal of $100:");
        bankAccount.accountSummary();
        
        System.out.println("\n-----------------------");
        
        // create a CheckingAccount
        CheckingAccount checkingAccount = new CheckingAccount("Jane", "Smith", 67890, 1.5);
        checkingAccount.deposit(300);
        System.out.println("\nChecking Account Summary:");
        checkingAccount.displayAccount();
        checkingAccount.processWithdrawal(350); // will trigger overdraft
        System.out.println("\nAfter withdrawal of $350:");
        checkingAccount.displayAccount();
    }
}
