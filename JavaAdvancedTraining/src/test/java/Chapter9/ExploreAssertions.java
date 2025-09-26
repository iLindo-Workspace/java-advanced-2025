package Chapter9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExploreAssertions {

    static int num1 , num2 ;
    @BeforeAll
    static void initialize(){
        num1 = 6; num2 = 3;

    }

    @Test
    @DisplayName("Test Sum of Two Numbers")
    void testSumOfTwoNumbers(){
        //Arrange - define initial and expected values / results
        int expected = 9;

        //Act / Actual - actual processing done by the system
        int actual  = num1 + num2 ;

        //Assert - compare the expected results with the actual results
        assertEquals(expected, actual, "Sum of " + num1 + " + " + num2 + " is " + expected);


    }

    @Test
    @DisplayName("Test Difference of Two Numbers")
    void testDifferenceOfTwoNumbers(){
        //Arrange - define initial and expected values / result
        int expected = 3;

        //Act / Actual - actual processing done by the system
        int actual  = num1 - num2;

        //Assert - compare the expected results with the actual results
        assertEquals(expected, actual, "Difference of " + num1 + " - " + num2 + " is " + expected);
    }

    @Test
    @DisplayName("Compute Sum, Difference, Product, Quotient")
    void testComputationOfNumbers(){
        //Arrange
        int expectedSum = 9, expectedDiff = 3, expectedProduct = 18;
        double expectedQuotient = 2.0;

        //Actual
        int actualSum = num1 + num2 ;
        int actualDiff = num1 - num2;
        int actualProduct = num1 * num2;
        double actualQuotient = num1 / num2;

        //Assert

        assertAll(
                () -> assertEquals(expectedSum, actualSum, "Sum of " + num1 + " + " + num2 + " is " + expectedSum),
                () -> assertEquals(expectedDiff, actualDiff, "Difference of " + num1 + " - " + num2 + " is " + expectedDiff),
                () -> assertEquals(expectedProduct, actualProduct, "Product of " + num1 + " x " + num2 + " is " + expectedProduct),
                () -> assertEquals(expectedQuotient, actualQuotient, "Quotient of " + num1 + " / " + num2 + " is " + expectedQuotient)
        );





    }
}
