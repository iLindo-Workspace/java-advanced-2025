import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


public class EmployeeTest {

    static Employee emp;

    @BeforeEach
    void setEmployee(){
        emp = new Employee("EM121","Odwa", "Tester",Positions.Junior,"IT",18000);
    }

    @AfterAll
    static void getCurrentEmpDetails(){
        String green = "\u001B[32m";
        String reset = "\u001B[0m";

        System.out.println(green + emp + reset + "\n\n");
    }

    @Test
    @DisplayName("Test raise salary increase")
    void testSalaryRaise() throws HighSalaryIncrease {
        double percentage = 0.10;
        double expectedIncreasedSalary = 19800.00; //Use any other amount for negative testing
        double initialSalary = emp.getSalary();


        double actualIncrease = 0;
        try{
            actualIncrease = emp.raiseSalary(percentage);
        }catch(HighSalaryIncrease ex){
            System.err.println(ex.getMessage());
        }

        assertEquals(expectedIncreasedSalary, actualIncrease, "A raise of 10% to R" + initialSalary +
                    " salary should give a new salary of R19800.00");
    }

    @Test
    @DisplayName("Test High Salary increase of > R5000")
    void testHighSalaryIncrease(){
        double percentage = 0.50;

        assertThrows(HighSalaryIncrease.class,
        () -> emp.raiseSalary(percentage)
        );
    }

    @Test
    @DisplayName("Test House allowance calculations")
    void testHouseAllowanceCalculations(){
        double expectedAllowance = 1440.00; //Use any other amount for negative testing

        double actualAllowance = emp.calcHouseAllowance();

        assertEquals(expectedAllowance, actualAllowance, "Allowance rate of 8% from the salary of R" + emp.getSalary() +
                        " should be R" + emp.calcHouseAllowance() + " but expected is R" + expectedAllowance );

    }

    @Test
    @DisplayName("Test Gross Salary calculations")
    void testGrossSalaryCalculations(){
        double expectedGross = 19440.00;

        double actualGrossSalary = emp.calcGrossSalary();

        assertEquals(expectedGross, actualGrossSalary, "Gross Salary = Salary R" + emp.getSalary() +
                " + House allowance of R" + emp.calcHouseAllowance() + " , but expected is R" + expectedGross);
    }

    @Test
    @DisplayName("Test Tax calculations")
    void testTaxCalculations(){
        double expectedTaxAmount = 2916.00;

        double actualTaxAmount = emp.calcTax();

        assertEquals(expectedTaxAmount, actualTaxAmount, "Tax deducted from gross salary of R" + emp.calcGrossSalary() +
                " should be 15%, which makes out R" + emp.calcTax());
    }

    @Test
    @DisplayName("Test Net Salary calculations")
    void testNetSalaryCalculations(){
        double expectedNetSalary = 16524.00;

        double actualNetSalary = emp.calcNetSalary();

        assertEquals(expectedNetSalary, actualNetSalary, "Net salary = Gross salary of R" + emp.calcGrossSalary() +
                " - Tax of R" + emp.calcTax());
    }

    @Test
    @DisplayName("Test Employee ID exception")
    void testEmployeeIDException(){
        Employee employee = new Employee();

        assertThrows(IllegalArgumentException.class,
                () -> employee.setID("225"));
    }

    @Test
    @DisplayName("Test Salary too low exception")
    void testSalaryException(){
        Employee employee = new Employee();

        assertThrows(IllegalArgumentException.class,
                () -> employee.setSalary(3000));
    }

    @Test
    @DisplayName("Test Promotion logic")
    void testPromotion(){
        Employee employee = new Employee("EM123", "Lindo", "Developer", Positions.Director, "IT", 17000);
        int yearsOfExperience = 11;
        Positions expectedPosition = Positions.Executive;

        Positions actualPosition = employee.promote(yearsOfExperience);

        assertEquals(expectedPosition, actualPosition, String.format("""
                
                For current position and years of experience is between 0 & 2 inclusive: you do not get promoted
                For current position of Junior or Intermediate and years of experience is between 3 & 5 inclusive:
                    Junior gets promoted to Intermediate
                    Intermediate gets promoted to Senior
                For current position of Intermediate or Senior and years of experience is between 6 & 10 inclusive:
                    Intermediate gets promoted to Senior
                    Senior gets promoted to Director
                For current position of Senior or Director and years of experience is more than 10 :
                    Senior gets promoted to Director
                    Director gets promoted to Executive
                """));

    }






}
