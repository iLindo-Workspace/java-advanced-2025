package Chapter8.Exercises;

/**
 * @author Lindokuhle Makanda
 * Thrown when the {@code Department} has invalid input for its field
 */
public class DepartmentException extends Exception{
    /**
     * Constructs an {@code DepartmentException} with the specified message
     * @param message The detail message
     */
    public DepartmentException(String message, String dep, int depID, int numOfEmployees){

        super("Failed to create Department: " + dep +
                "\nDepartmentID : " + depID +
                "\nNumber of Employees: " + numOfEmployees +
                "\n" + message + "\n\n");
    }

    public DepartmentException(String message) {
    }
}
