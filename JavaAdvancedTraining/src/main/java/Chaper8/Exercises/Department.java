package Chaper8.Exercises;

public class Department {
    private String department;
    private int departmentID;
    private int maxEmployees;


    public Department(String dep, int depID, int numOfEmployees) throws DepartmentException {
       this.department = dep;
       this.departmentID = depID;
       this.maxEmployees = numOfEmployees;
        setDepartment(dep);
        setDepartmentID(depID);
        setMaxEmployees(numOfEmployees);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) throws DepartmentException {

        if(department.length() != 2){
            throw new DepartmentException(
                    "Department name must be at least 2", getDepartment(),getDepartmentID(), getMaxEmployees());
        }
        department = department;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) throws DepartmentException {
        if(departmentID < 100 || departmentID > 499){
            throw new DepartmentException(
                    "DepartmentID must be at least 3 digits between [100-499]", getDepartment(),getDepartmentID(), getMaxEmployees());
        }
        this.departmentID = departmentID;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) throws DepartmentException {
        if(maxEmployees < 4 || maxEmployees > 10){
            throw new DepartmentException(
                    "Number of Employees must be between 4 minimum and 10 maximum", getDepartment(),getDepartmentID(), getMaxEmployees());
        }
        this.maxEmployees = maxEmployees;
    }


}
