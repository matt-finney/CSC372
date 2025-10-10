package CSC372Mod1;

public class CheckingAccount extends BankAccount
{
    private double interest_rate;
    private final double OVERDRAFT_FEE = 30;

    // add constructor
    public CheckingAccount(String first_name, String last_name, int account_ID, double interest_rate)
    {
        super(first_name, last_name, account_ID);
        this.interest_rate = interest_rate;
    }
    public void processWithdrawal(double amount) 
    {
        // check if withdrawal exceeds balance
        if (amount > getBalance()) 
        {
            double new_balance = getBalance() - amount - OVERDRAFT_FEE;
            setBalance(new_balance);
            System.out.printf("Withdrawal exceeds balance. Overdraft fee of $%.2f assessed. New balance: $%.2f%n", OVERDRAFT_FEE, new_balance);
        } 
        else 
        {
            setBalance(getBalance() - amount);
            System.out.printf("Withdrawal successful. New balance: $%.2f%n", getBalance());
        }
    }

    public void displayAccount()
    {
        accountSummary(); // inherited method
        System.out.printf("Interest rate: %.2f%%%n", interest_rate);
    }

    // getter
    public double getInterest_rate()
    {
        return interest_rate;
    }

    // setter
    public void setInterest_rate(double interest_rate)
    {
        this.interest_rate = interest_rate;
    }

}