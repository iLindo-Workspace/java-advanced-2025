package Chapter7.Inheritance;

public class MyTrapezium extends MyShape
{
    private double baseOne, baseTwo, height;

    public MyTrapezium(double base1, double base2, double height){
        super(0,0);
        setBaseOne(base1);
        setBaseTwo(base2);
        setHeight(height);
    }

    public double getBaseOne() {
        return baseOne;
    }

    public void setBaseOne(double baseOne) {
        this.baseOne = baseOne;
    }

    public double getBaseTwo() {
        return baseTwo;
    }

    public void setBaseTwo(double baseTwo) {
        this.baseTwo = baseTwo;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override  public double calcArea(){
        return 0.5 * (getBaseOne() + getBaseTwo()) * getHeight();
    }

    @Override
    public void display(String shape){
        System.out.println("\n================ " + shape + " ===============");
        System.out.println(String.format("""
                Base 1: %.2f
                Base 2: %.2f
                Height: %.2f
                Area: %.2f
                """,getBaseOne(), getBaseTwo(), getHeight(), calcArea()));
    }
}
