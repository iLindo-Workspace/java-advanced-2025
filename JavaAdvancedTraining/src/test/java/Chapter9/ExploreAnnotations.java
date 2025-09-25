package Chapter9;

import org.junit.jupiter.api.*;

/**
 * @author Lindokuhle Makanda
 * This class demonstrates use of different annotations from JUnit's library
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExploreAnnotations
{
    @BeforeAll
    static void setUp(){
        System.out.println("\u001B[32mGetting things started...\u001B[0m");
    }

    @AfterAll
    static void finish() {
        System.out.println("All tests are completed");
    }

    @BeforeEach
    void beforeEachTest(){
        System.err.println("Before Each Test...");
    }

    @Test
    @DisplayName("TC1 - First Test")
    @Order(1)
    @Tag("Sanity")
    void firstTest(){
        System.out.println("First Test Method");
    }

    @Test
    @DisplayName("TC2 - Second Test")
    @Order(3)
    @Tag("Regression")
    void secondTest(){
        System.out.println("Second Test Method");
    }

    @Test
    @DisplayName("TC3 - Third Test")
    @Order(2)
    @Tag("Integration")
    void thirdTest(){
        System.out.println("Third Method");
    }


    @Test
    @DisplayName("TC4 - Fourth Test")
    @Order(4)
    @Tag("Integration")
    @Tag("Regression")
    void fourthTest(){
        System.out.println("Fourth Method");
    }

}
