
    public interface IEmployee {
        /**
         * This method returns the new salary with the added pecentage
         * @param percentage The percentage to be added to salary
         * @return The new salary with the added percentage
         */
        double raiseSalary(double percentage) throws HighSalaryIncrease;

        /**
         * This method calculates and return house allowance amount
         * @return The house allowance amount
         */
        double calcHouseAllowance();

        /**
         * This method calculates and returns gross salary
         * @return Gross salary
         */
        double calcGrossSalary();

        /**
         * This method calculates and returns tax deduction
         * @return Tax deduction
         */
        double calcTax();

        /**
         * This method calculates and returns net salary
         * @return Net salary
         */
        double calcNetSalary();
    }
