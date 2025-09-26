package Chapter8.Exercises;

/**
 * @author Lindokuhle Makanda
 * Ths calss runs the code
 */
public class ThrowDepartmentException {
    public static void main(String[] args) {
        Department[] deps = new Department[6];
        String[] depNames = new String[]{"IT", "HR", "Finance", "A1", "Marketing", "Re"};
        int[] ids = {101,99,250,500,300,499};
        int[] employeeCount = {5,10,4,3,7,11};

        for(int i = 0; i < deps.length; i++)
        {
            try{
                    deps[i] = new Department(depNames[i], ids[i], employeeCount[i]);
                System.out.println("Department Created: " +  depNames[i] +
                                  "(ID: " + ids[i] + ")");
            }catch(DepartmentException ex){
                System.err.println(ex.getMessage());
            }
        }

    }
}

