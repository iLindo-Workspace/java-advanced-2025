package Chapter7.Inheritance;

public class StudentRunner
{
    public static void main(String[] args)
    {
        Student st = new Student("12345678","Odwa","Makanda", "C#");
        st.displayDetails();


        PartTimeStudent objSt = new PartTimeStudent("41587796", "Elizabeth", "Lisbon", "CSS", true);
        objSt.displayDetails();

    }
}
