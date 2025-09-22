package Chapter7;

public class BankAccountRunner
{
    public static void main(String[] args)
    {

        BankAccount objDebit = new BankAccount("Zola Mbini" , "42156799", AccountType.DEBIT, 800.00);
        BankAccount objBank = new BankAccount("Joe Smith", "123456789", AccountType.SAVINGS, 5000.00);

        objBank.transfer(objDebit, 1000.00);
        objDebit.displayDetails();
        objBank.deposit(3000);
        objBank.displayDetails();

        objBank.withdrawal(1000);
        objBank.displayDetails();
        System.out.println(String.format("""
                Current balance for (%s) is R %.2f
                """,objBank.getAccHolder(), objBank.getBalance() ));

        System.out.println(String.format("""
                Current balance for (%s) is R %.2f
                """,objDebit.getAccHolder(), objDebit.getBalance() ));



    }
}
