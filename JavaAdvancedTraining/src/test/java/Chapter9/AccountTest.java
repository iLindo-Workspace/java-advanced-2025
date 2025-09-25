package Chapter9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class AccountTest
{
    static BankAccount objAccount;

    @BeforeEach
    void setup(){
        objAccount = new BankAccount("Joe Smith", "123456", AccountType.CHEQUE, 10000);
    }

    @AfterEach
    void getCurrentAccountData(){
        String green = "\u001B[32m";
        String reset = "\u001B[0m";

        System.out.println(green + objAccount.displayDetails() + reset + "\n\n");
    }

    @Test
    @DisplayName("Test Account Deposit")
    void testDeposit(){
        //Arrange
        double amountToDeposit = 2000;
        double expectedBalance = 12000;

        //Actual
        objAccount.deposit(amountToDeposit);
        double actualBalance = objAccount.getBalance();

        //Assert
        assertEquals(expectedBalance, actualBalance);

    }

    @Test
    @DisplayName("Test Account Withdrawal")
    void testWithdrawal(){
        //Arrange
        double amountToWithdraw = 1000;
        double expectedBalance = 9000;

        //Actual
        try{
            objAccount.withdrawal(amountToWithdraw);
        }catch(InsufficientFundsException ex){
            System.out.println(ex.getMessage());
        }

        double actualBalance = objAccount.getBalance();

        //Assert
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    @DisplayName("Test Withdrawal - Insufficient Funds")
    void testWithdrawalInsufficientFunds(){
        double amountToWithdraw = 20000;
        assertThrows(InsufficientFundsException.class,
                () -> objAccount.withdrawal(amountToWithdraw)
                );
    }

    @Test
    @DisplayName("Test Account Transfer: From current to target account")
    void testTransfer(){
        //Arrange
        BankAccount objBankTransferAccount = new BankAccount("Simon Lee", "147852369", AccountType.DEBIT,20000);
        double amountToTransfer = 2000.00;
        double expectedBalanceAcount = 8000.00;
        double expectedBalanceTransferAccount = 22000.00;

        //Actual
        try{
            objAccount.transfer(objBankTransferAccount, amountToTransfer);
        }catch(InsufficientFundsException ex){
            System.err.println(ex.getMessage());
        }

        double actualAccountBalance = objAccount.getBalance();
        double actualTransferAccountBalance = objBankTransferAccount.getBalance();

        //Assert
        assertAll(
                () -> assertEquals(expectedBalanceAcount, actualAccountBalance, "After transferring R2000.00 from the " + objAccount.getAccType() +
                        " account The balance should be R8000.00"),
                () -> assertEquals(expectedBalanceTransferAccount, actualTransferAccountBalance, "After receiving a transfer amount of R2000.00" +
                        " balance should be R22000.00")
        );

    }

    @Test
    @DisplayName("Test Account Holder - Invalid name")
    void testInvalidAccountHolder(){
        assertThrows(IllegalArgumentException.class,
                () ->  objAccount.setAccHolder("Joe"));
    }

    @Test
    void testAccountNumberPrefix(){
        //Arrange
        String accNumber = "123456";
        String accountHolder = "John Smith";
        double balance = 5000;



        BankAccount objLoan = new BankAccount(accountHolder, accNumber, AccountType.LOAN,balance);
        BankAccount objDebit = new BankAccount(accountHolder, accNumber, AccountType.DEBIT,balance);
        BankAccount objCheque = new BankAccount(accountHolder, accNumber, AccountType.CHEQUE,balance);
        BankAccount objCredit = new BankAccount(accountHolder, accNumber, AccountType.CREDIT,balance);
        BankAccount objSavings = new BankAccount(accountHolder, accNumber, AccountType.SAVINGS,balance);


        assertAll(
                () -> assertEquals("LN-" + accNumber, objLoan.getAccNumber()),
                () -> assertEquals("DB-" + accNumber, objDebit.getAccNumber()),
                () -> assertEquals("CQ-" + accNumber, objCheque.getAccNumber()),
                () -> assertEquals("CR-" + accNumber, objCredit.getAccNumber()),
                () -> assertEquals("SV-" + accNumber, objSavings.getAccNumber())
        );


    }

}
