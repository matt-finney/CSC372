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

    // parameterized constructor
    public BankAccount(String firstName, String lastName, int accountID)
    {
        this.first_name = firstName;
        this.last_name = lastName;
        this.account_ID = accountID;
        this.balance = 0.0;
    }

    // deposit a value to the balance
    public void deposit(double value)
    {
        if (value < 0) 
        {
            System.out.println("Error: Cannot deposit negative amount");
            return;
        }
        this.balance += value;
    }
    
    // withdraw a value from the balance
    public void withdrawal(double value)
    {
        if (value < 0) 
        {
            System.out.println("Error: Cannot withdraw negative amount");
            return;
        }
        if (value > this.balance) 
        {
            System.out.println("Error: Insufficient funds");
            return;
        }
        this.balance -= value;
    }

    // prints all account information
    public void accountSummary()
    {
        System.out.printf
        (
            "First name: %s%nLast name: %s%nAccount ID: %d%nCurrent balance: %.2f%n",
            first_name, last_name, account_ID, balance
        );
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

    public int getAccount_ID() 
    {
        return account_ID;
    }

    public double getBalance() 
    {
        return balance;
    }

    // setters
    public void setFirst_name(String first_name) 
    {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) 
    {
        this.last_name = last_name;
    }
    
    public void setAccount_ID(int account_ID) 
    {
        if (account_ID < 0) 
        {
            System.out.println("Error: Account ID cannot be negative");
            return;
        }
        this.account_ID = account_ID;
    }

    public void setBalance(double balance) 
    {
        this.balance = balance;
    }
 }