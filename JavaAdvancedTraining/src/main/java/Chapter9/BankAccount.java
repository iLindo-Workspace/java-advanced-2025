package Chapter9;

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
        setAccType(type);
        setAccNumber(number);
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
        if(holder.length() < 4) {
            throw new IllegalArgumentException("Account holder name should at least be 4 characters");
        }

            this.accHolder = holder;
    }

    public String getAccHolder(){
        return this.accHolder;
    }

    /**
     * Set the account number with a prefix based on the {@code AccountType}
     * The prefix is set as follows: (DEBIT = DB, SAVINGS = SV, LOAN = LN, CHEQUE = CQ, CREDIT = CR)
     * @param number The account number from the user
     */

    private void setAccNumber(String number){

        if(getAccType().name().equalsIgnoreCase("Debit")){
             this.accNumber = "DB-" + number;
        }else if (getAccType().name().equalsIgnoreCase("Savings")){
            this.accNumber = "SV-" + number;
        }else if(getAccType().name().equalsIgnoreCase("Loan")){
            this.accNumber = "LN-" + number;
        }else if(getAccType().name().equalsIgnoreCase("Cheque")){
            this.accNumber = "CQ-" + number;
        }else{
            this.accNumber = "CR-" + number;
        }

//        String accPrefix = "";
//        if(getAccType() == AccountType.DEBIT){
//            accPrefix = "DB-";
//        }else if(getAccType() == AccountType.CHEQUE){
//            accPrefix = "CQ-";
//
//        }else if(getAccType() == AccountType.LOAN){
//            accPrefix = "LN-";
//        }else if(getAccType() == AccountType.SAVINGS){
//            accPrefix = "SV-";
//        }else if(getAccType() == AccountType.CREDIT){
//            accPrefix = "CR-";
//        }
//        this.accNumber = accPrefix + number;
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

    public void withdrawal(double amount) throws InsufficientFundsException {
        if(getBalance() < amount){
            throw new InsufficientFundsException("Insufficient funds" +
                    "\nCurrent Balance: R" + getBalance() +
                    "\nRequested Amount: R" + amount);
        }

        setBalance(this.balance - amount);
    }

    public void transfer(BankAccount targetAcc, double amount) throws InsufficientFundsException {
        this.withdrawal(amount);
        targetAcc.deposit(amount);
    }
    public String displayDetails()
    {
       return String.format("""
                Account Holder: %s (%s)
                Account Type: %s
                Balance: R %.2f
                """, getAccHolder(),getAccNumber(), getAccType().name(),getBalance());
    }



}
