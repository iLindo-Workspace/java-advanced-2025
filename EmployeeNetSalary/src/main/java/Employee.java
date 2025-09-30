
    /**
     * An Enum for the Positions that employees fall under
     */
    enum Positions{
        Junior, Intermediate, Senior,
        Director, Executive, None
    }
    public class Employee implements  IEmployee
    {

        //Class Attributes
        private String ID, name, jobTitle;
        //This attribute is required in the constructor parameters
        private String department;
        private double salary;
        private Positions position;

        //Constants
        private final double TAX = 0.15, HOUSE_ALLOWANCE = 0.08;

        public Employee(String id, String name, String jobTitle,Positions position, String dept, double basicSalary) {
            setID(id);
            setName(name);
            setJobTitle(jobTitle);
            setDepartment(dept);
            setSalary(basicSalary);
            setPosition(position);
        }

        public Employee(){

        }

        /**
         *Gets the private ID field
         * @return ID
         */
        public String getID() {
            return ID;
        }

        /**
         * Sets the private ID field
         * @param ID This is the Employee ID
         */
        public void setID(String ID) {
            if(!ID.toUpperCase().startsWith("EM")){
                throw  new IllegalArgumentException("Employee ID must start with \"EM\"");
            }

            this.ID = ID;
        }
        /**
         *Gets the private name field
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the private Employee name
         * @param name
         */
        public void setName(String name) {
            this.name = name;
        }
        /**
         *Gets the private job title field
         * @return jobTitle
         */
        public String getJobTitle() {
            return jobTitle;
        }

        /**
         * Sets the private job title field
         * @param jobTitle
         */
        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }
        /**
         *Gets the private department field
         * @return department
         */
        public String getDepartment() {
            return department;
        }

        /**
         * Sets the private department field
         * @param department
         */
        public void setDepartment(String department) {
            this.department = department;
        }
        /**
         *Gets the private salary field
         * @return salary
         */
        public double getSalary() {
            return salary;
        }

        /**
         * Sets the private salary field
         * @param salary
         */
        public void setSalary(double salary) {

            if(salary < 4000){
                throw new IllegalArgumentException("Employees basic salary should be R4000 or more");
            }

            this.salary = salary;
        }
        /**
         *Gets the private position field
         * @return position
         */
        public Positions getPosition() {
            return position;
        }

        /**
         * Sets the public position field
         * @param position
         */
        public void setPosition(Positions position) {
            this.position = position;
        }

        @Override
        public double raiseSalary(double percentage) throws HighSalaryIncrease {
            if(salary * percentage > 5000){
                throw new HighSalaryIncrease(salary * percentage, getName());
            }

            setSalary(salary + (salary * percentage));
            return getSalary();
        }

        Positions promote(int years)
        {
            Positions p = getPosition();

            if(years <= 2){
                return p;
            }else if((years >= 3 || years <= 5) && (getPosition() == Positions.Junior || getPosition() == Positions.Intermediate))
            {
                p = searchForNewPosition(getPosition().name());
            }else if((years >= 6 && years <= 10) && (getPosition() == Positions.Intermediate || getPosition() == Positions.Senior)){
                p = searchForNewPosition(getPosition().name());
            }else if(years > 10 && (getPosition() == Positions.Senior || getPosition() == Positions.Director)) {
                p = searchForNewPosition(getPosition().name());
            }
            setPosition(p);
            return p;
        }

        private Positions searchForNewPosition(String currentPosition)
        {
            if(currentPosition.equalsIgnoreCase("Junior")){
                return Positions.Intermediate;
            }else if(currentPosition.equalsIgnoreCase("Intermediate")){
                return Positions.Senior;
            }else if(currentPosition.equalsIgnoreCase("Senior")){
                return Positions.Director;
            }else{
                return Positions.Executive;
            }
        }



        @Override
        public double calcHouseAllowance() {
            return salary * HOUSE_ALLOWANCE;
        }

        @Override
        public double calcGrossSalary() {
            return salary + calcHouseAllowance();
        }

        @Override
        public double calcTax() {
            return calcGrossSalary() * TAX;
        }

        @Override
        public double calcNetSalary() {
            return calcGrossSalary() - calcTax();
        }

        @Override
        public String toString() {
            return String.format("""
                Employee: [%s] %s
                Title: %s
                Position: %s
                Department: %s
                
                ========== Salary Breakdown ==========
                Basic: R%.2f
                House Allowance: R%.2f
                Gross: R%.2f
                Tax Deduction: R%.2f
                Net: R%.2f
                ++++++++++++++++++++++++++++++++++++++
                """, getID(),getName(), getJobTitle(), getPosition(), getDepartment(),
                    getSalary(), calcHouseAllowance(), calcGrossSalary(), calcTax(), calcNetSalary());
        }
    }
