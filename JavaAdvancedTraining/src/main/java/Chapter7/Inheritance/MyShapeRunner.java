package Chapter7.Inheritance;

public class MyShapeRunner
{
    public static void main(String[] args) {
        MyShape objShape = new MyShape(8, 12);
        objShape.display("Shape");

        MyRectangle objRec = new MyRectangle(9,4);
        objRec.display("Rectangle");

        MySquare objSquare = new MySquare(9);
        objSquare.display("Square");

        MyCircle objCircle = new MyCircle(4);
        objCircle.display("Circle");

        MyTriangle objTriangle = new MyTriangle(10, 5);
        objTriangle.display("Triangle");

        MyTrapezium objTrapezium = new MyTrapezium(8,5,4);
        objTrapezium.display("Trapezium");


    }


}
