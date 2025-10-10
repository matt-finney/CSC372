package CSC372Mod1;

public class Module1 
{
    public static void main(String[] args) 
    {
        // create a BankAccount
        BankAccount bankAccount = new BankAccount("Ava", "Thompson", 90123);
        bankAccount.deposit(920);
        System.out.println("Bank Account Summary:");
        bankAccount.accountSummary();
        bankAccount.withdrawal(345);
        System.out.println("\nAfter withdrawal of $345:");
        bankAccount.accountSummary();
        
        System.out.println("\n-----------------------");
        
        // create a CheckingAccount
        CheckingAccount checkingAccount = new CheckingAccount("Liam", "Neeson", 33445, 2.10);
        checkingAccount.deposit(180);
        System.out.println("\nChecking Account Summary:");
        checkingAccount.displayAccount();
        checkingAccount.processWithdrawal(340); // will trigger overdraft
        System.out.println("\nAfter withdrawal of $340:");
        checkingAccount.displayAccount();
    }
}