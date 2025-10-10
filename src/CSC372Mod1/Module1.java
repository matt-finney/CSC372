package CSC372Mod1;

/*
 * CSC372 - Module 1
 * Matthew Finney
 * Test the BankAccount and CheckingAccount classes to show Inheritance and Polymorphism
 */
public class Module1 
{
    public static void main(String[] args) 
    {
        // create a BankAccount
        BankAccount bankAccount = new BankAccount("Noah", "Grossman", 48201);
        bankAccount.deposit(760);
        System.out.println("Bank Account Summary:");
        bankAccount.accountSummary();
        bankAccount.withdrawal(180);
        System.out.println("\nAfter withdrawal of $180:");
        bankAccount.accountSummary();
        
        System.out.println("\n-----------------------");
        
        // create a CheckingAccount
        CheckingAccount checkingAccount = new CheckingAccount("Sophia", "Rodriguez", 99012, 2.75);
        checkingAccount.deposit(250);
        System.out.println("\nChecking Account Summary:");
        checkingAccount.displayAccount();
        checkingAccount.processWithdrawal(420); // will trigger overdraft
        System.out.println("\nAfter withdrawal of $420:");
        checkingAccount.displayAccount();
    }
}