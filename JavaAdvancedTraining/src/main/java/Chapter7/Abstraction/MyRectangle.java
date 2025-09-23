package Chapter7.Abstraction;

public class MyRectangle extends MyShape
{
    private double length, width;

    public MyRectangle(int l, int w){
        setLength(l);;
        setWidth(w);;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public double calcArea() {
        return getLength() * getWidth();
    }

    @Override
    public double calcParameter() {
        return 2 * (getLength() + getWidth());
    }

    @Override
    public void display() {
        System.out.println(String.format("""
                ================= %s ===============
                Length: %.2f
                Width: %.2f
                Area: %.2f
                Parameter: %.2f
                """, getClass().getSimpleName(), getLength(),getWidth(), calcArea(), calcParameter()));
    }

    @Override
    public void draw() {
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < length; col++) {
                System.out.print("* ");
            }
            System.out.println(); // Move to the next line
        }

    }
}
