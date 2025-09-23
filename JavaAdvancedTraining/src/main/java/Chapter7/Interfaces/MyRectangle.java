package Chapter7.Interfaces;

/**
 * @author Lindokuhle Makanda
 * This class implements methods from the {@code IShape} and
 * {@code IGraphics} Interfaces
 */
public class MyRectangle implements IShape, IGraphics
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

    /**
     * Apply paint on the shape
     * @param color The color of the paint as a {@code string}
     */

    @Override
    public void applyPaint(String color) {

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

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    @Override
    public double getParameter() {
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
                
                """, getClass().getSimpleName(), getLength(),getWidth(), getArea(), getParameter()));
    }
}
