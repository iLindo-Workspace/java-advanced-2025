package Chapter7.Abstraction;

/**
 * @author Lindokuhle Makanda
 */

public abstract class MyShape
{
    /**
     * Calculate the Area
     * @return the area as a {@code double}
     */
    public abstract double calcArea();
    /**
     * Calculate the Parameter
     * @return the Parameter as a {@code double}
     */

    public abstract double calcParameter();

    /**
     * Display the details of the shape
     */
    public abstract void display();

    /**
     * Draw the shape
     */
    public abstract  void draw();


}
