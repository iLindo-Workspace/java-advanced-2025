package Chapter7.Inheritance;

/**
 * @author Lindokuhle Makanda
 * Child class that inherits from Student Class
 */

public class PartTimeStudent extends Student
{
    private boolean isEmployed; //Unique attribute

    public PartTimeStudent(String stNumber, String name, String lastName, String major, boolean employed)
    {
        super(stNumber, name,lastName,major);
        setEmployed(employed); ;
    }

    public boolean getIsEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }
    @Override
    public void displayDetails(){
        System.out.println("\nStudent: " + getName() +" (ST-" + getStNumber() + ")");
        System.out.println("Major: " + getMajor());
        System.out.println("Empoyed? : " + getIsEmployed()) ;
    }

}
