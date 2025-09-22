package Chapter7.Inheritance;

public class Student
{
    private String stNumber;
    private String firstName;
    private String lastName;
    private String major;

    /**
     * @author Lindokuhle Makanda
     * Parent class with common attributes for part-time and full-time
     */


    /**
     * Overloaded Constructor
     */

    public Student(String stNumber, String name, String lastName, String major)
    {
        setStNumber(stNumber); ;
        setFirstName(name); ;
        setLastName(lastName); ;
        setMajor(major); ;
    }

    public String getStNumber() {
        return stNumber;
    }

    public void setStNumber(String stNumber) {
        this.stNumber = stNumber;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void displayDetails()
    {
        System.out.println("\nStudent: " + getName() +" (ST-" + getStNumber() + ")");
        System.out.println("Major: " + getMajor());
    }

}
