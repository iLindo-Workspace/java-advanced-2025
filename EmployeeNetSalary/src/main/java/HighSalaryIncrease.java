
public class HighSalaryIncrease extends Exception {
    public HighSalaryIncrease(double increase, String name) {
        super(String.format("""
                Salary increase of R%.2f for %s is more that the threshold R5000
                """,increase, name));
    }
}

