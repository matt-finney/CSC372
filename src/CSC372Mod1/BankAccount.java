package CSC372Mod1;

/*
 * 
 */

 public class BankAccount
 {
    // attributes
    private String first_name;
    private String last_name;
    private int account_ID;
    private double balance;

    // default constructor
    public BankAccount()
    {
        this.first_name = null;
        this.last_name = null;
        this.account_ID = -1;
        this.balance = 0;
    }

    // deposit a value to the balance
    public void deposit(double value)
    {
        this.balance += value;
    }
    
    // withdraw a value from the balance
    public void withrawal(double value)
    {
        this.balance -= value;
    }

    // getters
    public String getFirst_name() 
    {
        return first_name;
    }

    public String getLast_name() 
    {
        return last_name;
    }

    public int getAccount_ID() {
        return account_ID;
    }

    // setters
 }