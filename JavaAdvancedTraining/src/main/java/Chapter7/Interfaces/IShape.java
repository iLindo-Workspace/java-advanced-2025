package Chapter7.Interfaces;

public interface IShape
{
    /**
     * Calculate the area of the shape
     * @return The calculated area
     */
    double getArea();

    /**
     * Calculate the parameter of the shape
     * @return The calculated parameter
     */
    double getParameter();

    /**
     * Display details of the shape
     */
    void display();
}
