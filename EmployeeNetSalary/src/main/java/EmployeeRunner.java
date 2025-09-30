/**
 * @author Lindokuhle Makanda
 * This is the Runner class for {@code Employee}
 */
public class EmployeeRunner {
    public static void main(String[] args) {
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String reset = "\u001B[0m";

        Employee[] employees = {
                new Employee("EM123", "Mike", "Developer", Positions.Junior, "IT", 25_000),
                new Employee("EM124", "Thabo", "Recruiter", Positions.Director, "HR", 26_000),
                new Employee("EM125", "Jessica", "Tester", Positions.Intermediate, "IT", 31_000),
                new Employee("EM126", "Lerato", "Accountant", Positions.Senior, "FINANCE", 34_000)
        };


        //Process the array and display all employees’ details and giving each a raise of 15%
        System.out.println(green + "Employee details after 15% salary increase\n" +
                "===================================================" + reset);
        for (Employee emp : employees) {
            try {
                emp.raiseSalary(0.15);
                System.out.println(emp);
            } catch (HighSalaryIncrease e){
                System.err.println(e.getMessage());
            }

        }

        //Promote each employee using 7 years of experience.
        System.out.println("\n" + green + "Employee details with 7 years experience promotion\n" +
                "===================================================" + reset);
        for (Employee emp : employees) {
            Positions p = emp.getPosition();

            emp.promote(7);
            if(p == emp.getPosition()){
                System.out.println(yellow + emp.getName() + " Doesn't qualify for promotion at this point..." + reset);
            }
            System.out.println(emp);

        }





    }
}
