package Chapter7;

public class Student
{
    String stNumber;
    String firstName;
    String lastName;
    String major;

    /**
     * Default Constructor
     * that assigns default values
     */
    public Student()
    {
        //To override these default values, an object will have to explicitly assign these values
        this.stNumber = "000000";
        this.firstName = "No Name";
        this.lastName = "No Lastname";
        this.major = "None";
    }

    /**
     * Overloaded Constructor
     */

    public Student(String stNumber, String name, String lastName, String major)
    {
        this.stNumber = stNumber;
        this.firstName = name;
        this.lastName = lastName;
        this.major = major;
    }

    public void displayDetails()
    {
        System.out.println("\nStudent: " + this.firstName + " " + this.lastName + " (ST-" + this.stNumber + ")");
        System.out.println("Major: " + this.major);
    }

}
