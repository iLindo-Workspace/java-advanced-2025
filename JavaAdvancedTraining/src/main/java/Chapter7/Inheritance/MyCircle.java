package Chapter7.Inheritance;

public class MyCircle extends MyShape
{
    private final double PI  = Math.PI;
    private int radius;

    public MyCircle(int radius){
        super(0, 0);
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    private void setRadius(int radius) {
        this.radius = radius;
    }
    @Override
    public double calcArea(){
        return this.PI * (getRadius() * getRadius());
    }

    @Override
    public void display(String shape){
        System.out.println("\n================ " + shape + " ===============");
        System.out.println(String.format("""
                PI: %.2f
                Radius: %d
                Area: %.2f
                """, this.PI, getRadius(), this.calcArea()));

    }
}
