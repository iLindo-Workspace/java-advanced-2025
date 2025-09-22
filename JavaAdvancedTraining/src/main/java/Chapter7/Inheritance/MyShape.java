package Chapter7.Inheritance;

/**
 * @author Lindokuhle Makanda
 * Protected - Attributes are accessible within the Parent class,
 * and Any other class that inherits from this class
 */

public class MyShape
{
    protected int length,width;

    public MyShape(int length, int width) {
        setLength(length);
        setWidth(width);
    }


    public double calcArea(){
        return this.length * this.width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void display(String shape){
        System.out.println("\n================ " + shape + " ===============");
        System.out.println("Length: " + getLength());
        System.out.println("Width: " + getWidth());
        System.out.println("Area: " + this.calcArea());
    }


}
