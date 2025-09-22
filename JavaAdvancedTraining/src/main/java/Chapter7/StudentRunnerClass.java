package Chapter7;

public class StudentRunnerClass
{
    public static void main(String[] args)
    {

        Student st = new Student("123456","Kelvin","Smith","Python");
        st.displayDetails();

        Student st1 = new Student("456789","Odwa","Makanda", "C#");
        st1.displayDetails();
    }
}
