package Chapter7.Inheritance;

public class MyTriangle extends MyShape
{
    private double base, height;

    public MyTriangle(double base, double height){
        super(0,0);
        setBase(base);
        setHeight(height);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override  public double calcArea(){
        return 0.5 * getBase() * getHeight();
    }

    @Override
    public void display(String shape){
        System.out.println("\n================ " + shape + " ===============");
        System.out.println(String.format("""
                Base: %.2f
                Height: %.2f
                Area: %.2f
                """,getBase() , getHeight(), calcArea()));
    }
}
