package Chapter9;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ParameterizedTests {
    @ParameterizedTest(name = "Test Pass Mark - [{index}] : {arguments}")// {index} is the execution number, and {argument} is the test mark passed per execution
    @ValueSource(doubles = {77.5, 50, 64.9, 56, 23.8, 47}) //this of these values are derived from your test techniques
    void testPassMark(double testMark){
        boolean expected = true;

        boolean actual = testMark >= 65;

        assertEquals(expected, actual, "Pass mark should be >= 65 [" + testMark + "]" );
        System.out.println("testMark = " + testMark);
    }

    @ParameterizedTest(name = "Test names - {index} : {arguments}")
    @ValueSource(strings = {"Kate", "Jake", "Jessica", "Carol", "Tom", "John", "Jekson", "Mike"})
    void testNameStartWithJ(String name){
        assertTrue(name.startsWith("J"), name + " doesn't start with 'J'");

        System.out.print(name + " ");
    }

    @ParameterizedTest
    @CsvSource(value = {"Milk,20.99,50", "Cheease,55,25", "Eggs,78.99,70", "Bread,18.99,15"})//Everything inside the value should b inside double quotes
    void testLowStockProducts(String product, double price, int qtyInStock){
        assertTrue(qtyInStock < 50, "There is enough stock [" + qtyInStock + "] for [" + product + "]");
        System.out.println("product = " + product + ", price = " + price + ", qtyInStock = " + qtyInStock);;
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/Student Test Marks.csv", numLinesToSkip = 1)
    void testFailedStudents(String firstName, String lastName, int testMark){

        assertTrue(testMark < 65, "Student [" + firstName + " " + lastName + "] managed to pass the test [" + testMark + "]" );
        System.out.println("firstName = " + firstName + ", lastName = " + lastName + ", testMark = " + testMark);

    }

    @ParameterizedTest
    @MethodSource("hobbies")
    void testHobbies(String hobby){
        System.out.println("hobby = " + hobby);
    }

    @ParameterizedTest(name ="[{index}] : Test Even Numbers - {arguments}")
    @MethodSource("randomNumbers")
    void testEvenNumbers(int number){
        assertTrue(number % 2 == 0 , number + " is not an even number");

        System.out.println("number = " + number);

    }

//    @ParameterizedTest
//    @MethodSource // you don't have to specify the method name if your test method has the same name as your method
//    void randomNumbers(int number){
//        System.out.println("number = " + number);
//    }

    @ParameterizedTest(name ="[{index}] : Test Odd Numbers - {arguments}")
    @MethodSource("Chapter9.DataStore#randomNumbers")
    void testOddNumers(int number){
        assertTrue(number %2 != 0, number + " is not an odd number");

    }


    static List<Integer> randomNumbers(){
        Random rnd = new Random();
        List<Integer> numbers = new ArrayList<>();
        int count = rnd.nextInt(5, 15);


        for(int i = 0; i < count; i++){

            numbers.add(rnd.nextInt(10,70));
        }

        return numbers;
    }

    static Stream<String> hobbies(){
        return  Stream.of("Tennis","Hokey","Chess", "Hiking","Soccer");
    }


}
