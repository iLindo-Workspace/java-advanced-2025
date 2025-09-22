package Chapter7;

/**
 * @author Lindokuhle Makanada
 * - This class demonstrates different access levels
 * Public - Class members can be accessible outside the class
 * Private - Class members are only accessible within the class
 *
 */
enum AccountType{
    DEBIT, SAVINGS, CREDIT, LOAN, CHEQUE
}
public class BankAccount
{
    private String accHolder;
    private String accNumber;
    private AccountType accType;
    private double balance;


    public BankAccount(String holder, String number, AccountType type, double balance)
    {
        setAccHolder(holder);
        setAccNumber(number);
        setAccType(type);
        setBalance(balance);
    }

    public void setBalance(double bal){
        this.balance = bal;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setAccHolder(String holder)
    {
        if(holder.length() < 4){
            System.err.println("Account holder name should at least be 4 characters");
        }else{
            this.accHolder = holder;
        }


    }

    public String getAccHolder(){
        return this.accHolder;
    }


    private void setAccNumber(String number){
        this.accNumber = number;
    }

    public String getAccNumber(){
        return this.accNumber;
    }

    public void setAccType(AccountType type){
        this.accType = type;
    }

    public AccountType getAccType(){
        return this.accType;
    }

    public void deposit(double amount){

        setBalance( this.balance + amount);
    }

    public void withdrawal(double amount){
        setBalance(this.balance - amount);
    }

    public void transfer(BankAccount targetAcc, double amount){
        this.withdrawal(amount);
        targetAcc.deposit(amount);
    }
    public void displayDetails()
    {
        System.out.println(String.format("""
                Account Holder: %s (%s)
                Account Type: %s
                Balance: R %.2f
                """, getAccHolder(),getAccNumber(), getAccType().name(),getBalance()));
    }



}
