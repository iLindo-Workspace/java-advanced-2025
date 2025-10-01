import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


public class EmployeeTest {

    static Employee emp;
    static String green = "\u001B[32m";
    static String yellow = "\u001B[33m";
    static String reset = "\u001B[0m";
    @BeforeEach
    void setEmployee(){
        emp = new Employee("EM121","Odwa", "Tester",Positions.Junior,"IT",18000);
    }

    @AfterEach
    void getCurrentEmpDetails(TestInfo testInfo){

        if(testInfo.getTags().contains("ShowDetails")){
            System.out.println(emp + "\n\n");
        }

    }

    @Test
    @Tag("ShowDetails")
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

        System.out.println("Expected Basic Salary after raise: " + yellow + "R" + expectedIncreasedSalary + reset + "\n");
    }

    @Test
    @Tag("NoDetails")
    @DisplayName("Test HighSalaryException ")
    void testHighSalaryIncrease(){
        double percentage = 0.50;

        assertThrows(HighSalaryIncrease.class,
        () -> emp.raiseSalary(percentage)
        );

        System.out.println(green + "Exception Thrown successfully" + reset);
    }

    @Test
    @Tag("ShowDetails")
    @DisplayName("Test House allowance calculations")
    void testHouseAllowanceCalculations(){
        double expectedAllowance = 1440.00; //Use any other amount for negative testing

        double actualAllowance = emp.calcHouseAllowance();

        assertEquals(expectedAllowance, actualAllowance, "Allowance rate of 8% from the salary of R" + emp.getSalary() +
                        " should be R" + emp.calcHouseAllowance() + " but expected is R" + expectedAllowance );

        System.out.println("Expected House Allowance : " + yellow + "R" + expectedAllowance + reset + "\n");
    }

    @Test
    @Tag("ShowDetails")
    @DisplayName("Test Gross Salary calculations")
    void testGrossSalaryCalculations(){
        double expectedGross = 19440.00;

        double actualGrossSalary = emp.calcGrossSalary();

        assertEquals(expectedGross, actualGrossSalary, "Gross Salary = Salary R" + emp.getSalary() +
                " + House allowance of R" + emp.calcHouseAllowance() + " , but expected is R" + expectedGross);

        System.out.println("Expected Gross Salary : " + yellow + "R" + expectedGross + reset + "\n");
    }

    @Test
    @Tag("ShowDetails")
    @DisplayName("Test Tax calculations")
    void testTaxCalculations(){
        double expectedTaxAmount = 2916.00;

        double actualTaxAmount = emp.calcTax();

        assertEquals(expectedTaxAmount, actualTaxAmount, "Tax deducted from gross salary of R" + emp.calcGrossSalary() +
                " should be 15%, which makes out R" + emp.calcTax());

        System.out.println("Expected Tax Amount : " + yellow + "R" + expectedTaxAmount + reset + "\n");
    }

    @Test
    @Tag("ShowDetails")
    @DisplayName("Test Net Salary calculations")
    void testNetSalaryCalculations(){
        double expectedNetSalary = 16524.00;

        double actualNetSalary = emp.calcNetSalary();

        assertEquals(expectedNetSalary, actualNetSalary, "Net salary = Gross salary of R" + emp.calcGrossSalary() +
                " - Tax of R" + emp.calcTax());

        System.out.println("Expected Net Salary : " + yellow + "R" + expectedNetSalary + reset + "\n");
    }

    @Test
    @Tag("NoDetails")
    @DisplayName("Test Employee ID exception")
    void testEmployeeIDException(){
        Employee employee = new Employee();

        assertThrows(IllegalArgumentException.class,
                () -> employee.setID("225"));

        System.out.println(green + "Exception Thrown successfully" + reset);
    }

    @Test
    @Tag("NoDetails")
    @DisplayName("Test Salary too low exception")
    void testSalaryException(){
        Employee employee = new Employee();

        assertThrows(IllegalArgumentException.class,
                () -> employee.setSalary(3000));

        System.out.println(green + "Exception Thrown successfully" + reset);
    }

    @Test
    @Tag("NoDetails")
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
        System.out.println(green + "Promoted successfully" + reset + "\n\n" + employee);
    }






}
