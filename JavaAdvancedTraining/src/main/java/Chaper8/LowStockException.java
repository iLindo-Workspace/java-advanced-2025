package Chaper8;

/**
 * @author Lindokuhle Makanda
 * Thrown when a {@code Product} has low quantity in stock
 */
public class LowStockException extends Exception{
    /**
     * Constructs an {@code LowStockException} with specified details message
     * @param msg the detail message
     */
    public LowStockException(String msg){super(msg);}
}
