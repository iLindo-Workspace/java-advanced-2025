package Chapter7.Interfaces;

public interface IGraphics {
    //methods here are public and abstract by default

    /**
     * Apply paint on the shape
     * @param color The color of the paint as a {@code string}
     */
    void applyPaint(String color);

    void draw();

}
